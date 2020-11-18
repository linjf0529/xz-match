package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.ReserveRecord;
import com.xz.match.entity.ReserveRecordExample;
    /**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
public interface ReserveRecordService{


    long countByExample(ReserveRecordExample example);

    int deleteByExample(ReserveRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReserveRecord record);

    int insertSelective(ReserveRecord record);

    List<ReserveRecord> selectByExample(ReserveRecordExample example);

    ReserveRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(ReserveRecord record,ReserveRecordExample example);

    int updateByExample(ReserveRecord record,ReserveRecordExample example);

    int updateByPrimaryKeySelective(ReserveRecord record);

    int updateByPrimaryKey(ReserveRecord record);

}
