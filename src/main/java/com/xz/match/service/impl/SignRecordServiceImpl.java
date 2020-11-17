package com.xz.match.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.xz.match.mapper.SignRecordMapper;
import com.xz.match.entity.SignRecordExample;
import com.xz.match.entity.SignRecord;
import com.xz.match.service.SignRecordService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class SignRecordServiceImpl implements SignRecordService{

    @Resource
    private SignRecordMapper signRecordMapper;

    @Override
    public long countByExample(SignRecordExample example) {
        return signRecordMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SignRecordExample example) {
        return signRecordMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return signRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SignRecord record) {
        return signRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(SignRecord record) {
        return signRecordMapper.insertSelective(record);
    }

    @Override
    public List<SignRecord> selectByExample(SignRecordExample example) {
        return signRecordMapper.selectByExample(example);
    }

    @Override
    public SignRecord selectByPrimaryKey(Long id) {
        return signRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SignRecord record,SignRecordExample example) {
        return signRecordMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(SignRecord record,SignRecordExample example) {
        return signRecordMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(SignRecord record) {
        return signRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SignRecord record) {
        return signRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String,Object>> countSignRecordDispatchInfo(Map<String, Object> param) {
        return signRecordMapper.countSignRecordDispatchInfo(param);
    }

    @Override
    public List<SignRecord> findBy(JSONObject param) {
        return signRecordMapper.findBy(param);
    }
}
