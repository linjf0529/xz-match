package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.MatchDispatchSet;
import com.xz.match.entity.MatchDispatchSetExample;
    /**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchDispatchSetService{


    long countByExample(MatchDispatchSetExample example);

    int deleteByExample(MatchDispatchSetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchDispatchSet record);

    int insertSelective(MatchDispatchSet record);

    List<MatchDispatchSet> selectByExample(MatchDispatchSetExample example);

    MatchDispatchSet selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchDispatchSet record,MatchDispatchSetExample example);

    int updateByExample(MatchDispatchSet record,MatchDispatchSetExample example);

    int updateByPrimaryKeySelective(MatchDispatchSet record);

    int updateByPrimaryKey(MatchDispatchSet record);

}
