package com.xz.match.controller;

import com.xz.match.service.MatchCertificateService;
import com.xz.match.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: xz-match
 * @description: 赛事证书配置
 * @author: Linjf
 * @create date: 2020-11-17 08:54
 **/
@RestController("")
public class MatchCertificateController {
    @Resource
    private MatchCertificateService matchCertificateService;
    /**
     *
     * @param request
     * @return
     */
    @GetMapping
    public ResponseResult MatchCertificate(HttpServletRequest request){
//        JSONObject params=getJSONObject(request);
////        ValidateUtils.notNull(params.getString("matchId"), MessageLocale.EMPTY_CODE,"赛事id不能为空");
//        //查询赛事模板
//        params.put("type",1);
//        MatchCertificate matchCertificate= matchCertificateService.findOne(params);
//        MatchCertificateVo matchCertificateVo=new MatchCertificateVo();
//        matchCertificateVo.setMatchId(params.getString("matchId"));
//        if(matchCertificate!=null){
//            matchCertificateVo.setId(matchCertificate.getId());
//            matchCertificateVo.setState(2);
//        }else {
//            matchCertificateVo.setState(1);
//        }
//        return ResponseResult.getResponse().setData(matchCertificateVo);
        return null;
    }
}
