package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.SignRecordExample;
import com.xz.match.entity.SignRecord;
    /**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface SignRecordService{


    long countByExample(SignRecordExample example);

    int deleteByExample(SignRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SignRecord record);

    int insertSelective(SignRecord record);

    List<SignRecord> selectByExample(SignRecordExample example);

    SignRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(SignRecord record,SignRecordExample example);

    int updateByExample(SignRecord record,SignRecordExample example);

    int updateByPrimaryKeySelective(SignRecord record);

    int updateByPrimaryKey(SignRecord record);

}
