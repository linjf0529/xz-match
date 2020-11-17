package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.xz.match.mapper.SubjectSignFieldMapper;
import com.xz.match.entity.SubjectSignField;
import com.xz.match.entity.SubjectSignFieldExample;
import com.xz.match.service.SubjectSignFieldService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
@Service
@Transactional
public class SubjectSignFieldServiceImpl implements SubjectSignFieldService{

    @Resource
    private SubjectSignFieldMapper subjectSignFieldMapper;

    @Override
    public long countByExample(SubjectSignFieldExample example) {
        return subjectSignFieldMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SubjectSignFieldExample example) {
        return subjectSignFieldMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return subjectSignFieldMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SubjectSignField record) {
        return subjectSignFieldMapper.insert(record);
    }

    @Override
    public int insertSelective(SubjectSignField record) {
        return subjectSignFieldMapper.insertSelective(record);
    }

    @Override
    public List<SubjectSignField> selectByExample(SubjectSignFieldExample example) {
        return subjectSignFieldMapper.selectByExample(example);
    }

    @Override
    public SubjectSignField selectByPrimaryKey(Long id) {
        return subjectSignFieldMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SubjectSignField record,SubjectSignFieldExample example) {
        return subjectSignFieldMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(SubjectSignField record,SubjectSignFieldExample example) {
        return subjectSignFieldMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(SubjectSignField record) {
        return subjectSignFieldMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SubjectSignField record) {
        return subjectSignFieldMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SubjectSignField> findBy(Map<String, Object> param) {
        return subjectSignFieldMapper.findBy(param);
    }
}
