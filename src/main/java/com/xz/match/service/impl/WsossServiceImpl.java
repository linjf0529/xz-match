package com.xz.match.service.impl;

import com.chinanetcenter.api.entity.HttpClientResult;
import com.chinanetcenter.api.entity.PutPolicy;
import com.chinanetcenter.api.exception.WsClientException;
import com.chinanetcenter.api.util.Config;
import com.chinanetcenter.api.util.DateUtil;
import com.chinanetcenter.api.wsbox.FileUploadManage;
import com.xz.match.service.WsossService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.StringUtils;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.file.FSConstants;
import com.xz.match.utils.file.FSMessageLocal;
import com.xz.match.utils.file.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

@Service
public class WsossServiceImpl implements WsossService {
    private static final Logger logger = LoggerFactory.getLogger(WsossServiceImpl.class);
    // 创建上传对象
    FileUploadManage fileUploadManage = new FileUploadManage();


    public ResponseResult uploadImage(final byte[] imageContent, String imageName, String imageBucket, String fileKeyWithFolder) {
        return upload(imageContent, imageName, imageBucket, "IMAGE", fileKeyWithFolder);
    }

    public ResponseResult upload(final byte[] imageContent, String imageName, String imageBucket, String imageType, String fileKeyWithFolder) {
        Config.init(FSConstants.WSOSS_AK, FSConstants.WSOSS_SK, FSConstants.WSOSS_PUT_URL, FSConstants.WSOSS_GET_URL, FSConstants.WSOSS_MGR_URL);
        logger.debug("^_^ file upload image name is {}, image bucket is {}, image type is {},fileKeyWithFolder is {}",
                imageName, imageBucket, imageType, fileKeyWithFolder);
        ValidateUtils.notEmpty(imageType, FSMessageLocal.IMAGE_TYPE_IS_EMPTY);//图片类型为空
        // base64转inputStream
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageContent);
        try {
            String returnBody = "key=$(key)&fname=$(fname)&fsize=$(fsize)&url=$(url)&hash=$(hash)&mimeType=$(mimeType)";
            PutPolicy putPolicy = new PutPolicy();
            putPolicy.setOverwrite(0); //不覆盖上传
            putPolicy.setDeadline(String.valueOf(DateUtil.nextDate(1, new Date()).getTime()));
            putPolicy.setReturnBody(returnBody);
            putPolicy.setScope(imageBucket + ":" + fileKeyWithFolder);
            HttpClientResult result = fileUploadManage.upload(imageBucket, fileKeyWithFolder, imageName, inputStream, putPolicy);
            // 上传成功图片URL保存到图片库
            if (200 == (result.getStatus())) {
                Image image = new Image();
                String str = result.getResponse();
                if (StringUtils.isNotEmpty(str)) {
                    image.setImageUrl(str.substring(str.indexOf("url") + 4, str.lastIndexOf("&",str.indexOf("hash") + 5)));
                    image.setImageId(str.substring(str.indexOf("hash") + 5, str.lastIndexOf("&")));
                }
                image.setImageName(imageName);
                image.setImageBucket(imageBucket);
                image.setImageType("IMAGE");
                return ResponseResult.ok().setData(image);
            }
        } catch (WsClientException e) {
            logger.error("### wsoss upload error", e.getMessage());
        }
        return ResponseResult.fail("上传图片失败");
    }

    /**
     * base64转inputStream
     *
     * @param base64byte
     * @return
     */
    public static InputStream baseToInputStream(final byte[] base64byte) {
        ByteArrayInputStream stream = null;
        try {
            stream = new ByteArrayInputStream(base64byte);
        } catch (Exception e) {
            logger.error("###### fastDFS upload error msg:{}", e.getMessage());
        }
        return stream;
    }
}
