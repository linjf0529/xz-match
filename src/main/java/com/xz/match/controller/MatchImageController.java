package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinanetcenter.api.entity.HttpClientResult;
import com.chinanetcenter.api.entity.PutPolicy;
import com.chinanetcenter.api.exception.WsClientException;
import com.chinanetcenter.api.util.Config;
import com.chinanetcenter.api.util.DateUtil;
import com.chinanetcenter.api.wsbox.FileUploadManage;
import com.xz.match.entity.MatchImage;
import com.xz.match.entity.MatchScoreConfig;
import com.xz.match.service.MatchImageService;
import com.xz.match.service.WsossService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.StringUtils;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.aop.AllowAnonymous;
import com.xz.match.utils.file.FSConstants;
import com.xz.match.utils.file.FSMessageLocal;
import com.xz.match.utils.file.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @program: xz-match
 * @description: 赛事相册
 * @author: Linjf
 * @create date: 2020-11-17 19:55
 **/
@RestController
@RequestMapping("/matchs/image")
public class MatchImageController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(MatchImageController.class);

    FileUploadManage fileUploadManage = new FileUploadManage();

    @Resource
    private MatchImageService matchImageService;
    /**
     * 上传文件至网宿云
     **/
    @AllowAnonymous
    @PostMapping("/wsoss/upload")
    public ResponseResult wsossUpload(MultipartHttpServletRequest multipartRequest)
            throws IOException {
        // 获得文件：
        MultipartFile mf = multipartRequest.getFile("file");
        ValidateUtils.notNull(mf, FSMessageLocal.IMAGE_FILE_IS_EMPTY);
        // 获得文件名：
        String filename = mf.getOriginalFilename();
        String imageName = StringUtils.getUUID() + filename;

        String bucketName = FSConstants.WSOSS_BUCKET_NAME_DEFAULT;
        // 指定上传文件夹
        String fileKeyWithFolder = StringUtils.msNull("xz-match") + "/" + imageName + System.currentTimeMillis();
        logger.debug("^_^ file upload image name is {}, bucket name is {},fileKeyWithFolder is {}", imageName, bucketName, fileKeyWithFolder);
        String tmpFilename=filename.toLowerCase();
        ValidateUtils.isTrue((tmpFilename.endsWith(".jpg") || tmpFilename.endsWith(".png") || tmpFilename.endsWith(".jpeg")
                || tmpFilename.endsWith(".bmp")
                || tmpFilename.endsWith(".pdf") || tmpFilename.endsWith(".doc") || tmpFilename.endsWith(".docx")
                || tmpFilename.endsWith(".xls") || tmpFilename.endsWith(".xlsx")
        ), 0,"文件格式不正确");

        ValidateUtils.notEmpty(bucketName, FSMessageLocal.IMAGE_BUCKET_NAME_IS_EMPTY);
        Config.init(FSConstants.WSOSS_AK, FSConstants.WSOSS_SK, FSConstants.WSOSS_PUT_URL, FSConstants.WSOSS_GET_URL, FSConstants.WSOSS_MGR_URL);
        try {
            String returnBody = "key=$(key)&fname=$(fname)&fsize=$(fsize)&url=$(url)&hash=$(hash)&mimeType=$(mimeType)";
            PutPolicy putPolicy = new PutPolicy();
            //不覆盖上传
            putPolicy.setOverwrite(0);
            putPolicy.setDeadline(String.valueOf(DateUtil.nextDate(1, new Date()).getTime()));
            putPolicy.setReturnBody(returnBody);
            putPolicy.setScope(bucketName + ":" + fileKeyWithFolder);
            HttpClientResult result = fileUploadManage.upload(bucketName, fileKeyWithFolder, imageName, mf.getInputStream(), putPolicy);
            logger.debug("### wsoss upload result {}", result);
            // 上传成功图片URL保存到图片库
            if (200 == (result.getStatus())) {
                Image image = new Image();
                String str = result.getResponse();
                if (StringUtils.isNotEmpty(str)) {
                    image.setImageUrl(str.substring(str.indexOf("url") + 4, str.lastIndexOf("&",str.indexOf("hash") + 5)));
                    image.setImageId(str.substring(str.indexOf("hash") + 5, str.lastIndexOf("&")));
                }
                image.setImageName(imageName);
                image.setImageBucket(bucketName);
                image.setImageType("IMAGE");
                return ResponseResult.ok().setData(image);
            }
        } catch (WsClientException e) {
            e.printStackTrace();
        }
        return ResponseResult.getResponse(FSMessageLocal.IMAGE_UPLOAD_FAILED);

    }

    /**
     * 赛事照片列表
     * @param request
     * @return
     */
    @AllowAnonymous
    @GetMapping
    public ResponseResult findMatchImage(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        return matchImageService.findBy(getPageParam(request),param);
    }
    /**
     * 批量保存赛事照片
     * @param matchImage
     * @return
     */
    @AllowAnonymous
    @PostMapping("/batch")
    public ResponseResult batchSaveMatchImage(@RequestBody MatchImage matchImage){
        ValidateUtils.notNull(matchImage.getMatchId(),"赛事id不能为空");
        ValidateUtils.notNull(matchImage.getSubjectId(),"科目id不能为空");
        ValidateUtils.notNull(matchImage.getBackgroundURL(),"背景图片不能为空");
        String timestamp = String.valueOf(new Date().getTime());
        for(String url:matchImage.getBackgroundURL()){
            matchImage.setUrl(url);
            matchImage.setCreatedTime(Long.valueOf(timestamp));
            matchImageService.insert(matchImage);
            matchImage.setId(null);
            matchImage.setUrl(null);
        }
        return ResponseResult.ok();
    }

    /**
     * 保存赛事照片
     * @param matchImage
     * @return
     */
    @AllowAnonymous
    @PostMapping
    public ResponseResult saveMatchImage(@RequestBody MatchImage matchImage){
        ValidateUtils.notNull(matchImage.getMatchId(),"赛事id不能为空");
        ValidateUtils.notNull(matchImage.getSubjectId(),"科目id不能为空");
        String timestamp = String.valueOf(new Date().getTime());
        if(matchImage.getId()==null){
            matchImage.setCreatedTime(Long.valueOf(timestamp));
            matchImageService.insert(matchImage);
        }else {
            matchImage.setLastAccess(Long.valueOf(timestamp));
            matchImageService.updateByPrimaryKeySelective(matchImage);
        }
        return ResponseResult.ok();
    }

    /**
     * 删除赛事照片
     * @param id
     * @param request
     * @return
     */
    @AllowAnonymous
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult deleteMatchScoreConfig(@PathVariable("id") Long id, HttpServletRequest request){
        int count= matchImageService.deleteByPrimaryKey(id);
        return ResponseResult.ok().setData(count);
    }
}
