package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.xz.match.entity.ReserveRecord;
import com.xz.match.entity.ReserveRecordExample;
import com.xz.match.mapper.ReserveRecordMapper;
import com.xz.match.service.ReserveRecordService;
/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
@Service
public class ReserveRecordServiceImpl implements ReserveRecordService{

    @Resource
    private ReserveRecordMapper reserveRecordMapper;

    @Override
    public long countByExample(ReserveRecordExample example) {
        return reserveRecordMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReserveRecordExample example) {
        return reserveRecordMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return reserveRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ReserveRecord record) {
        return reserveRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(ReserveRecord record) {
        return reserveRecordMapper.insertSelective(record);
    }

    @Override
    public List<ReserveRecord> selectByExample(ReserveRecordExample example) {
        return reserveRecordMapper.selectByExample(example);
    }

    @Override
    public ReserveRecord selectByPrimaryKey(Long id) {
        return reserveRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ReserveRecord record,ReserveRecordExample example) {
        return reserveRecordMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ReserveRecord record,ReserveRecordExample example) {
        return reserveRecordMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ReserveRecord record) {
        return reserveRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReserveRecord record) {
        return reserveRecordMapper.updateByPrimaryKey(record);
    }

}
