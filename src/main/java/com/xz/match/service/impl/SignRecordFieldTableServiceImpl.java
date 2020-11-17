package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.mapper.SignRecordFieldTableMapper;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.SignRecordFieldTable;
import com.xz.match.entity.SignRecordFieldTableExample;
import com.xz.match.service.SignRecordFieldTableService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
@Service
@Transactional
public class SignRecordFieldTableServiceImpl implements SignRecordFieldTableService{

    @Resource
    private SignRecordFieldTableMapper signRecordFieldTableMapper;

    @Override
    public long countByExample(SignRecordFieldTableExample example) {
        return signRecordFieldTableMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SignRecordFieldTableExample example) {
        return signRecordFieldTableMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return signRecordFieldTableMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SignRecordFieldTable record) {
        return signRecordFieldTableMapper.insert(record);
    }

    @Override
    public int insertSelective(SignRecordFieldTable record) {
        return signRecordFieldTableMapper.insertSelective(record);
    }

    @Override
    public List<SignRecordFieldTable> selectByExample(SignRecordFieldTableExample example) {
        return signRecordFieldTableMapper.selectByExample(example);
    }

    @Override
    public SignRecordFieldTable selectByPrimaryKey(Long id) {
        return signRecordFieldTableMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SignRecordFieldTable record,SignRecordFieldTableExample example) {
        return signRecordFieldTableMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(SignRecordFieldTable record,SignRecordFieldTableExample example) {
        return signRecordFieldTableMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(SignRecordFieldTable record) {
        return signRecordFieldTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SignRecordFieldTable record) {
        return signRecordFieldTableMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SignRecordFieldTable> findBy(Map paramMap) {
        return signRecordFieldTableMapper.findBy(paramMap);
    }
}
