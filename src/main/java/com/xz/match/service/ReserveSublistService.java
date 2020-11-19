package com.xz.match.service;

import com.xz.match.entity.ReserveSublistExample;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.ReserveSublist;
import com.xz.match.entity.vo.ReserveSublistVO;
import org.apache.ibatis.annotations.Param;

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

    List<ReserveSublist> findBy(Map<String,Object> map);

    /**
     * 根据项目id获取预约日期
     * @param subjectId
     * @return
     */
    List<ReserveSublistVO> getReserveDate(Long subjectId);

    /**
     * 预约时间
     * @param map
     * @return
     */
    List<ReserveSublistVO> getReserveTime(Map<String,Object> map);
}
