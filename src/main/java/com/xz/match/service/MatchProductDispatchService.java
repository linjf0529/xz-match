package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.MatchProductDispatch;
import com.xz.match.entity.MatchProductDispatchExample;
    /**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchProductDispatchService{


    long countByExample(MatchProductDispatchExample example);

    int deleteByExample(MatchProductDispatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchProductDispatch record);

    int insertSelective(MatchProductDispatch record);

    List<MatchProductDispatch> selectByExample(MatchProductDispatchExample example);

    MatchProductDispatch selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchProductDispatch record,MatchProductDispatchExample example);

    int updateByExample(MatchProductDispatch record,MatchProductDispatchExample example);

    int updateByPrimaryKeySelective(MatchProductDispatch record);

    int updateByPrimaryKey(MatchProductDispatch record);

}
