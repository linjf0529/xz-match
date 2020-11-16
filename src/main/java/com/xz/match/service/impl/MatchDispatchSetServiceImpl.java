package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.xz.match.entity.MatchDispatchSet;
import com.xz.match.mapper.MatchDispatchSetMapper;
import com.xz.match.entity.MatchDispatchSetExample;
import com.xz.match.service.MatchDispatchSetService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchDispatchSetServiceImpl implements MatchDispatchSetService{

    @Resource
    private MatchDispatchSetMapper matchDispatchSetMapper;

    @Override
    public long countByExample(MatchDispatchSetExample example) {
        return matchDispatchSetMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchDispatchSetExample example) {
        return matchDispatchSetMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchDispatchSetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchDispatchSet record) {
        return matchDispatchSetMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchDispatchSet record) {
        return matchDispatchSetMapper.insertSelective(record);
    }

    @Override
    public List<MatchDispatchSet> selectByExample(MatchDispatchSetExample example) {
        return matchDispatchSetMapper.selectByExample(example);
    }

    @Override
    public MatchDispatchSet selectByPrimaryKey(Long id) {
        return matchDispatchSetMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchDispatchSet record,MatchDispatchSetExample example) {
        return matchDispatchSetMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchDispatchSet record,MatchDispatchSetExample example) {
        return matchDispatchSetMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchDispatchSet record) {
        return matchDispatchSetMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchDispatchSet record) {
        return matchDispatchSetMapper.updateByPrimaryKey(record);
    }

}
