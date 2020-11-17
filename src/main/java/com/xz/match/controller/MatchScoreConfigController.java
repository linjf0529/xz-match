package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.xz.match.entity.MatchInfo;
import com.xz.match.entity.MatchScoreConfig;
import com.xz.match.entity.MatchScoreConfigExample;
import com.xz.match.service.MatchScoreConfigService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.exception.CommonException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: xz-match
 * @description:成绩证书配置
 * @author: Linjf
 * @create date: 2020-11-17 09:08
 **/
@RestController
@RequestMapping("/matchs/score/config")
public class MatchScoreConfigController extends BaseController{
    @Resource
    private MatchScoreConfigService matchScoreConfigService;

    /**
     * 根据subjectId获取成绩参数
     * @param request
     * @return
     */
    @GetMapping
    public ResponseResult getScoreConfig(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        ValidateUtils.notNull(param.getString("subjectId"),"科目id不能为空");
        List<MatchScoreConfig> matchScoreConfigs= matchScoreConfigService.findBy(param);
        return ResponseResult.ok().setData(matchScoreConfigs);
    }
    /**
     * 保存赛事成绩参数
     * @param matchScoreConfig
     * @param
     * @return
     */
    @PostMapping
    public ResponseResult saveMatchScoreConfig(@RequestBody MatchScoreConfig matchScoreConfig){
        ValidateUtils.notNull(matchScoreConfig.getSubjectId(),"科目id不能为空");
        return matchScoreConfigService.save(matchScoreConfig);
    }
    /**
     * 删除成绩参数配置
     *
     * @param id      id
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult deleteMatchScoreConfig(@PathVariable("id") Long id, HttpServletRequest request){
        int count= matchScoreConfigService.deleteByPrimaryKey(id);
        return ResponseResult.ok().setData(count);
    }
}
