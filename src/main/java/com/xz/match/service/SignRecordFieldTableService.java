package com.xz.match.service;

import java.util.List;
import java.util.Map;

import com.xz.match.entity.SignRecordFieldTable;
import com.xz.match.entity.SignRecordFieldTableExample;
    /**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
public interface SignRecordFieldTableService{


    long countByExample(SignRecordFieldTableExample example);

    int deleteByExample(SignRecordFieldTableExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SignRecordFieldTable record);

    int insertSelective(SignRecordFieldTable record);

    List<SignRecordFieldTable> selectByExample(SignRecordFieldTableExample example);

    SignRecordFieldTable selectByPrimaryKey(Long id);

    int updateByExampleSelective(SignRecordFieldTable record,SignRecordFieldTableExample example);

    int updateByExample(SignRecordFieldTable record,SignRecordFieldTableExample example);

    int updateByPrimaryKeySelective(SignRecordFieldTable record);

    int updateByPrimaryKey(SignRecordFieldTable record);

    List<SignRecordFieldTable> findBy(Map paramMap);
}
