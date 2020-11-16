package com.xz.match.controller;

import com.xz.match.entity.MatchInfo;
import com.xz.match.service.MatchInfoService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.exception.CommonException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenwf
 * @date 2020/11/16
 */
@RestController
public class TestController {
    @Resource
    private MatchInfoService matchInfoService;

    @GetMapping("/test")
    public ResponseResult test(){
        List<MatchInfo> matchInfos = new ArrayList<>();
        matchInfos = matchInfoService.get();
        if(matchInfos.isEmpty()){
            throw new CommonException("ashdashal哈佛哈");
        }
        return ResponseResult.ok().setData(matchInfos);
    }
}
