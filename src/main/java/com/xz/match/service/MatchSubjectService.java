package com.xz.match.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.MatchSubjectExample;
import com.xz.match.entity.MatchSubject;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchSubjectService{


    long countByExample(MatchSubjectExample example);

    int deleteByExample(MatchSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchSubject record);

    int insertSelective(MatchSubject record);

    List<MatchSubject> selectByExample(MatchSubjectExample example);

    MatchSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchSubject record,MatchSubjectExample example);

    int updateByExample(MatchSubject record,MatchSubjectExample example);

    int updateByPrimaryKeySelective(MatchSubject record);

    int updateByPrimaryKey(MatchSubject record);

    ResponseResult findSubjectByMatchId(Long matchId);

    ResponseResult allSubject(PageParam pageParam, JSONObject param);
}
