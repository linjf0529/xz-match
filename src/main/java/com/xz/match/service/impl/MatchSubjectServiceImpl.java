package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.xz.match.entity.MatchSubjectExample;
import com.xz.match.mapper.MatchSubjectMapper;
import com.xz.match.entity.MatchSubject;
import com.xz.match.service.MatchSubjectService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchSubjectServiceImpl implements MatchSubjectService{

    @Resource
    private MatchSubjectMapper matchSubjectMapper;

    @Override
    public long countByExample(MatchSubjectExample example) {
        return matchSubjectMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchSubjectExample example) {
        return matchSubjectMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchSubjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchSubject record) {
        return matchSubjectMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchSubject record) {
        return matchSubjectMapper.insertSelective(record);
    }

    @Override
    public List<MatchSubject> selectByExample(MatchSubjectExample example) {
        return matchSubjectMapper.selectByExample(example);
    }

    @Override
    public MatchSubject selectByPrimaryKey(Long id) {
        return matchSubjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchSubject record,MatchSubjectExample example) {
        return matchSubjectMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchSubject record,MatchSubjectExample example) {
        return matchSubjectMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchSubject record) {
        return matchSubjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchSubject record) {
        return matchSubjectMapper.updateByPrimaryKey(record);
    }

}
