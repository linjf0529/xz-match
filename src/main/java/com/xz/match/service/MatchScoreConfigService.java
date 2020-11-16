package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.MatchScoreConfigExample;
import com.xz.match.entity.MatchScoreConfig;
    /**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchScoreConfigService{


    long countByExample(MatchScoreConfigExample example);

    int deleteByExample(MatchScoreConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchScoreConfig record);

    int insertSelective(MatchScoreConfig record);

    List<MatchScoreConfig> selectByExample(MatchScoreConfigExample example);

    MatchScoreConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchScoreConfig record,MatchScoreConfigExample example);

    int updateByExample(MatchScoreConfig record,MatchScoreConfigExample example);

    int updateByPrimaryKeySelective(MatchScoreConfig record);

    int updateByPrimaryKey(MatchScoreConfig record);

}
