package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.xz.match.entity.MatchProduct;
import com.xz.match.mapper.MatchProductMapper;
import com.xz.match.entity.MatchProductExample;
import com.xz.match.service.MatchProductService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchProductServiceImpl implements MatchProductService{

    @Resource
    private MatchProductMapper matchProductMapper;

    @Override
    public long countByExample(MatchProductExample example) {
        return matchProductMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchProductExample example) {
        return matchProductMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchProduct record) {
        return matchProductMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchProduct record) {
        return matchProductMapper.insertSelective(record);
    }

    @Override
    public List<MatchProduct> selectByExample(MatchProductExample example) {
        return matchProductMapper.selectByExample(example);
    }

    @Override
    public MatchProduct selectByPrimaryKey(Long id) {
        return matchProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchProduct record,MatchProductExample example) {
        return matchProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchProduct record,MatchProductExample example) {
        return matchProductMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchProduct record) {
        return matchProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchProduct record) {
        return matchProductMapper.updateByPrimaryKey(record);
    }

}
