package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.xz.match.mapper.MatchProductSubMapper;
import com.xz.match.entity.MatchProductSub;
import com.xz.match.entity.MatchProductSubExample;
import com.xz.match.service.MatchProductSubService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchProductSubServiceImpl implements MatchProductSubService{

    @Resource
    private MatchProductSubMapper matchProductSubMapper;

    @Override
    public long countByExample(MatchProductSubExample example) {
        return matchProductSubMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchProductSubExample example) {
        return matchProductSubMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchProductSubMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchProductSub record) {
        return matchProductSubMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchProductSub record) {
        return matchProductSubMapper.insertSelective(record);
    }

    @Override
    public List<MatchProductSub> selectByExample(MatchProductSubExample example) {
        return matchProductSubMapper.selectByExample(example);
    }

    @Override
    public MatchProductSub selectByPrimaryKey(Long id) {
        return matchProductSubMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchProductSub record,MatchProductSubExample example) {
        return matchProductSubMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchProductSub record,MatchProductSubExample example) {
        return matchProductSubMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchProductSub record) {
        return matchProductSubMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchProductSub record) {
        return matchProductSubMapper.updateByPrimaryKey(record);
    }

}
