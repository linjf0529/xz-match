package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.xz.match.entity.MatchScore;
import com.xz.match.entity.MatchScoreExample;
import com.xz.match.mapper.MatchScoreMapper;
import com.xz.match.service.MatchScoreService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchScoreServiceImpl implements MatchScoreService{

    @Resource
    private MatchScoreMapper matchScoreMapper;

    @Override
    public long countByExample(MatchScoreExample example) {
        return matchScoreMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchScoreExample example) {
        return matchScoreMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchScoreMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchScore record) {
        return matchScoreMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchScore record) {
        return matchScoreMapper.insertSelective(record);
    }

    @Override
    public List<MatchScore> selectByExample(MatchScoreExample example) {
        return matchScoreMapper.selectByExample(example);
    }

    @Override
    public MatchScore selectByPrimaryKey(Long id) {
        return matchScoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchScore record,MatchScoreExample example) {
        return matchScoreMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchScore record,MatchScoreExample example) {
        return matchScoreMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchScore record) {
        return matchScoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchScore record) {
        return matchScoreMapper.updateByPrimaryKey(record);
    }

}
