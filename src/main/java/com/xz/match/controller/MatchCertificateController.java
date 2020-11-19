package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.MatchCertificate;
import com.xz.match.entity.MatchCertificateSublist;
import com.xz.match.entity.SignRecord;
import com.xz.match.service.MatchCertificateService;
import com.xz.match.service.MatchCertificateSublistService;
import com.xz.match.service.SignRecordService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.StringUtils;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.aop.AllowAnonymous;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: xz-match
 * @description: 赛事证书配置
 * @author: Linjf
 * @create date: 2020-11-17 08:54
 **/
@RestController
@RequestMapping("/matchs/certificate")
public class MatchCertificateController extends BaseController{
    @Resource
    private MatchCertificateService matchCertificateService;

    @Resource
    private MatchCertificateSublistService matchCertificateSublistService;

    @Resource
    private SignRecordService signRecordService;
    /**
     * 根据项目id获取模板详情
     * @param request
     * @return
     * @throws
     */
    @AllowAnonymous
    @GetMapping("/details")
    public ResponseResult getDetails(HttpServletRequest request) {
        JSONObject params=getJSONObject(request);
        Long subjectId=params.getLong("subjectId");
        ValidateUtils.notNull(subjectId,"项目id不能为空");
        MatchCertificate matchCertificate=matchCertificateService.getCertificateBySubjectId(subjectId);
        if(matchCertificate!=null){
            Map<String, Object> map=new HashMap<>();
            map.put("certificateId",matchCertificate.getId());
            List<MatchCertificateSublist> list=matchCertificateSublistService.findBy(map);
            matchCertificate.setSublist(list);
        }
        return ResponseResult.ok().setData(matchCertificate);
    }

    /**
     * 保存赛事证书
     * @param matchCertificate
     * @return
     */
    @AllowAnonymous
    @PostMapping
    public ResponseResult save(@RequestBody MatchCertificate matchCertificate) {
        List<MatchCertificateSublist> sublists=matchCertificate.getSublist();
        matchCertificate.setType(2);
        if(matchCertificate.getId()!=null){
            matchCertificateService.updateByPrimaryKeySelective(matchCertificate);
        }else {
            matchCertificateService.insert(matchCertificate);
        }
        if(sublists==null){
            return ResponseResult.ok();
        }
        if(sublists.size()>0){
            Long certificateId=matchCertificate.getId();
            List<Long> idList=new ArrayList<>();
            for(MatchCertificateSublist sublist:sublists){
                if (sublist.getId()!=null){
                    idList.add(sublist.getId());
                }
            }
            Map<String,Object> map=new HashMap<>();
            map.put("idList",idList);
            map.put("certificateId",certificateId);
            matchCertificateSublistService.deleteSubject(map);
            for(MatchCertificateSublist sublist:sublists){
                sublist.setCertificateId(certificateId);
                if(sublist.getId()==null){
                    matchCertificateSublistService.insert(sublist);
                }else {
                    matchCertificateSublistService.updateByPrimaryKeySelective(sublist);
                }
            }
        }
        return ResponseResult.ok();
    }

    /**
     * 证书保存到网宿云 返回URL
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/fileUrl")
    @AllowAnonymous
    public ResponseResult getFileUrl(HttpServletRequest request, HttpServletResponse response) {
        JSONObject params=getJSONObject(request);
        ValidateUtils.notNull(params.getString("userId"),"UserId不能为空");
        ValidateUtils.notNull(params.getString("subjectId"),"赛事不能为空");
        MatchCertificate matchCertificate=matchCertificateService.getCertificateBySubjectId(params.getLong("subjectId"));
        ValidateUtils.notNull(matchCertificate,"证书模板不存在!");
        JSONObject signJson=new JSONObject();
        signJson.put("subjectId",params.getLong("subjectId"));
        signJson.put("userId",params.getLong("userId"));
        List<SignRecord> signRecords=signRecordService.findBy(signJson);
        ValidateUtils.notEmpty(signRecords,0,"找不到报名记录");
        Integer size=40;
        String fontName="微软雅黑";
        if(matchCertificate.getSize()!=null && matchCertificate.getSize()!=0){
            size=matchCertificate.getSize();
        }
        if(StringUtils.isNotEmpty(matchCertificate.getFont())){
            fontName=matchCertificate.getFont();
        }
        Map<String,Object> map=new HashMap<>();
        map.put("certificateId",matchCertificate.getId());
        map.put("recordId",signRecords.get(0).getId());
        List<MatchCertificateSublist> sublists=matchCertificateSublistService.getCertificateSublist(map);
        ByteArrayOutputStream out=null;
        ResponseResult responseResult=null;
        try {
            String path=matchCertificate.getUrl();
            URL url = new URL(encode(path,"UTF-8"));
            BufferedImage bufferedImage= ImageIO.read(url);
            Graphics2D g2=bufferedImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            Font font=new Font(fontName,Font.BOLD,size);
            g2.setFont(font);
            Color color=new Color(0,0,0);
            g2.setColor(color);
            if(sublists!=null){
                for(MatchCertificateSublist sublist:sublists){
                    if(StringUtils.isNotEmpty(sublist.getScore())&&StringUtils.isNotEmpty(sublist.getPositionX())&&StringUtils.isNotEmpty(sublist.getPositionY())){
                        g2.drawString(sublist.getScore(),Integer.valueOf(sublist.getPositionX())-40,Integer.valueOf(sublist.getPositionY()));
                    }
                }
            }
            out = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"png",out);
            bufferedImage.flush();
            byte[] buffer=out.toByteArray();
            //上传至网宿云oss
            responseResult=matchCertificateService.uploadImage(buffer);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ValidateUtils.notNull(responseResult,"操作失败!");
        return responseResult;
    }

    /**
     * 路径中文编码转换
     * @param str
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     */
    public String encode(String str, String charset) throws UnsupportedEncodingException {
        String zhPattern = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(zhPattern);
        Matcher m = p.matcher(str);
        StringBuffer b = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(b, URLEncoder.encode(m.group(0), charset));
        }
        m.appendTail(b);
        return b.toString();
    }
}
