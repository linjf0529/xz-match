package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.xz.match.entity.MatchProductDispatch;
import com.xz.match.entity.MatchProductDispatchExample;
import com.xz.match.mapper.MatchProductDispatchMapper;
import com.xz.match.service.MatchProductDispatchService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchProductDispatchServiceImpl implements MatchProductDispatchService{

    @Resource
    private MatchProductDispatchMapper matchProductDispatchMapper;

    @Override
    public long countByExample(MatchProductDispatchExample example) {
        return matchProductDispatchMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchProductDispatchExample example) {
        return matchProductDispatchMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchProductDispatchMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchProductDispatch record) {
        return matchProductDispatchMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchProductDispatch record) {
        return matchProductDispatchMapper.insertSelective(record);
    }

    @Override
    public List<MatchProductDispatch> selectByExample(MatchProductDispatchExample example) {
        return matchProductDispatchMapper.selectByExample(example);
    }

    @Override
    public MatchProductDispatch selectByPrimaryKey(Long id) {
        return matchProductDispatchMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchProductDispatch record,MatchProductDispatchExample example) {
        return matchProductDispatchMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchProductDispatch record,MatchProductDispatchExample example) {
        return matchProductDispatchMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchProductDispatch record) {
        return matchProductDispatchMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchProductDispatch record) {
        return matchProductDispatchMapper.updateByPrimaryKey(record);
    }

}
