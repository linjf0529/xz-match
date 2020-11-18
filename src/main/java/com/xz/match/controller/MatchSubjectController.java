package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.service.MatchInfoService;
import com.xz.match.service.MatchSubjectService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.aop.AllowAnonymous;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chenwf
 * @date 2020/11/18
 */
@RestController
@RequestMapping("/match/subject")
public class MatchSubjectController extends BaseController {
    @Resource
    private MatchSubjectService matchSubjectService;

    @GetMapping("/allSubject")
    @AllowAnonymous
    public ResponseResult allSubject(HttpServletRequest request) {
        JSONObject param = getJSONObject(request);
        return matchSubjectService.allSubject(getPageParam(request),param);
    }

    /**
     * 赛事对应科目
     * @param request
     * @return
     */
    @GetMapping("/findSubjectByMatchId")
    @AllowAnonymous
    public ResponseResult findSubjectByMatchId(@RequestParam Long matchId, HttpServletRequest request){
        return matchSubjectService.findSubjectByMatchId(matchId);
    }
}
