package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.entity.MatchProductReceiveSetExample;
import java.util.List;
import com.xz.match.entity.MatchProductReceiveSet;
import com.xz.match.mapper.MatchProductReceiveSetMapper;
import com.xz.match.service.MatchProductReceiveSetService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchProductReceiveSetServiceImpl implements MatchProductReceiveSetService{

    @Resource
    private MatchProductReceiveSetMapper matchProductReceiveSetMapper;

    @Override
    public long countByExample(MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchProductReceiveSetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchProductReceiveSet record) {
        return matchProductReceiveSetMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchProductReceiveSet record) {
        return matchProductReceiveSetMapper.insertSelective(record);
    }

    @Override
    public List<MatchProductReceiveSet> selectByExample(MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.selectByExample(example);
    }

    @Override
    public MatchProductReceiveSet selectByPrimaryKey(Long id) {
        return matchProductReceiveSetMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchProductReceiveSet record,MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchProductReceiveSet record,MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchProductReceiveSet record) {
        return matchProductReceiveSetMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchProductReceiveSet record) {
        return matchProductReceiveSetMapper.updateByPrimaryKey(record);
    }

}
