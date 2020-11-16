package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.entity.MatchStockExample;
import java.util.List;
import com.xz.match.entity.MatchStock;
import com.xz.match.mapper.MatchStockMapper;
import com.xz.match.service.MatchStockService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchStockServiceImpl implements MatchStockService{

    @Resource
    private MatchStockMapper matchStockMapper;

    @Override
    public long countByExample(MatchStockExample example) {
        return matchStockMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchStockExample example) {
        return matchStockMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchStockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchStock record) {
        return matchStockMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchStock record) {
        return matchStockMapper.insertSelective(record);
    }

    @Override
    public List<MatchStock> selectByExample(MatchStockExample example) {
        return matchStockMapper.selectByExample(example);
    }

    @Override
    public MatchStock selectByPrimaryKey(Long id) {
        return matchStockMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchStock record,MatchStockExample example) {
        return matchStockMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchStock record,MatchStockExample example) {
        return matchStockMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchStock record) {
        return matchStockMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchStock record) {
        return matchStockMapper.updateByPrimaryKey(record);
    }

}
