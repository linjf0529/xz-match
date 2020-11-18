package com.xz.match.service;

import com.xz.match.entity.ReserveInfo;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.ReserveInfoExample;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;

/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
public interface ReserveInfoService{


    long countByExample(ReserveInfoExample example);

    int deleteByExample(ReserveInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReserveInfo record);

    int insertSelective(ReserveInfo record);

    List<ReserveInfo> selectByExample(ReserveInfoExample example);

    ReserveInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(ReserveInfo record,ReserveInfoExample example);

    int updateByExample(ReserveInfo record,ReserveInfoExample example);

    int updateByPrimaryKeySelective(ReserveInfo record);

    int updateByPrimaryKey(ReserveInfo record);

    public ResponseResult findBy(PageParam pageParam, Map<String, Object> param);
}
