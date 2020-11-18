package com.xz.match.service;

import com.xz.match.entity.ReserveSublistExample;
import java.util.List;
import com.xz.match.entity.ReserveSublist;
    /**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
public interface ReserveSublistService{


    long countByExample(ReserveSublistExample example);

    int deleteByExample(ReserveSublistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReserveSublist record);

    int insertSelective(ReserveSublist record);

    List<ReserveSublist> selectByExample(ReserveSublistExample example);

    ReserveSublist selectByPrimaryKey(Long id);

    int updateByExampleSelective(ReserveSublist record,ReserveSublistExample example);

    int updateByExample(ReserveSublist record,ReserveSublistExample example);

    int updateByPrimaryKeySelective(ReserveSublist record);

    int updateByPrimaryKey(ReserveSublist record);

}
