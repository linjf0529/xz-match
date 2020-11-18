package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.emums.MatchScoreDefaultConfig;
import com.xz.match.entity.MatchScore;
import com.xz.match.entity.MatchScoreConfig;
import com.xz.match.entity.SignRecord;
import com.xz.match.service.MatchScoreService;
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
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: xz-match
 * @description: 赛事成绩
 * @author: Linjf
 * @create date: 2020-11-17 11:24
 **/
@RestController
@RequestMapping("/matchs/score")
public class MatchScoreController extends BaseController{
    @Resource
    private MatchScoreService matchScoreService;
    @Resource
    private SignRecordService signRecordService;


    @AllowAnonymous
    @GetMapping("/record")
    public ResponseResult findSignRecordScore(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        return matchScoreService.findSignRecordScore(getPageParam(request),param);
    }
    @GetMapping
    public ResponseResult getScore(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        ValidateUtils.notNull(param.getString("subjectId"),"科目id不能为空");
        ValidateUtils.notNull(param.getString("recordId"),"报名记录不能为空");
        List<MatchScore> matchScores=matchScoreService.getMatchScoreList(param);
        return ResponseResult.ok().setData(matchScores);
    }

    /**
     * 修改或保存成绩
     * @param matchScores
     * @return
     */
    @PostMapping
    public ResponseResult create(@RequestBody List<MatchScore> matchScores)  {
        ValidateUtils.notNull(matchScores, "参数异常");
        //原本的成绩保存
        SignRecord signRecord=signRecordService.selectByPrimaryKey(matchScores.get(0).getRecordId());
        ValidateUtils.notNull(signRecord, "无效的报名记录");
        for(MatchScore matchScore:matchScores){
            if(matchScore.getShowState()==2){
                //默认值赋值
                if(MatchScoreDefaultConfig.MATCH_NAME.getCode().equals(matchScore.getScoreId())){
                    if(signRecord.getMatchName().equals(matchScore.getScore())){
                        continue;
                    }else {
                        matchScore.setScore(signRecord.getMatchName());
                    }
                }else if (MatchScoreDefaultConfig.SUBJECT_NAME.getCode().equals(matchScore.getScoreId())){
                    if(signRecord.getSubjectName().equals(matchScore.getScore())){
                        continue;
                    }else {
                        matchScore.setScore(signRecord.getSubjectName());
                    }
                }else if (MatchScoreDefaultConfig.NAME.getCode().equals(matchScore.getScoreId())){
                    if(signRecord.getName().equals(matchScore.getScore())){
                        continue;
                    }else {
                        matchScore.setScore(signRecord.getName());
                    }
                }else if (MatchScoreDefaultConfig.MATCH_NO.getCode().equals(matchScore.getScoreId())){
                    if(signRecord.getMatchNo().equals(matchScore.getScore())){
                        continue;
                    }else {
                        matchScore.setScore(signRecord.getMatchNo());
                    }
                }
            }
            if(matchScore.getId()!=null){
                matchScoreService.updateByPrimaryKeySelective(matchScore);
            }else {
                matchScoreService.insert(matchScore);
            }
        }
        return ResponseResult.ok();
    }
}
