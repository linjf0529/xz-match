package com.xz.match.service;

import com.xz.match.entity.MatchProductReceiveSetExample;
import java.util.List;
import com.xz.match.entity.MatchProductReceiveSet;
    /**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchProductReceiveSetService{


    long countByExample(MatchProductReceiveSetExample example);

    int deleteByExample(MatchProductReceiveSetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchProductReceiveSet record);

    int insertSelective(MatchProductReceiveSet record);

    List<MatchProductReceiveSet> selectByExample(MatchProductReceiveSetExample example);

    MatchProductReceiveSet selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchProductReceiveSet record,MatchProductReceiveSetExample example);

    int updateByExample(MatchProductReceiveSet record,MatchProductReceiveSetExample example);

    int updateByPrimaryKeySelective(MatchProductReceiveSet record);

    int updateByPrimaryKey(MatchProductReceiveSet record);

}
