package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.MatchInfo;
import com.xz.match.entity.MatchInfoExample;

/**
 * @author chenwf
 * @date 2020/11/16
 */
public interface MatchInfoService {


    int deleteByPrimaryKey(String id);

    int insert(MatchInfo record);

    int insertSelective(MatchInfo record);

    MatchInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MatchInfo record);

    int updateByPrimaryKey(MatchInfo record);

    int updateBatch(List<MatchInfo> list);

    int batchInsert(List<MatchInfo> list);

    List<MatchInfo> get();

    long countByExample(MatchInfoExample example);

    int deleteByExample(MatchInfoExample example);

    List<MatchInfo> selectByExample(MatchInfoExample example);

    int updateByExampleSelective(MatchInfo record, MatchInfoExample example);

    int updateByExample(MatchInfo record, MatchInfoExample example);
}








