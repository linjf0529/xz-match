package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.MatchScore;
import com.xz.match.entity.MatchScoreExample;
    /**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchScoreService{


    long countByExample(MatchScoreExample example);

    int deleteByExample(MatchScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchScore record);

    int insertSelective(MatchScore record);

    List<MatchScore> selectByExample(MatchScoreExample example);

    MatchScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchScore record,MatchScoreExample example);

    int updateByExample(MatchScore record,MatchScoreExample example);

    int updateByPrimaryKeySelective(MatchScore record);

    int updateByPrimaryKey(MatchScore record);

}
