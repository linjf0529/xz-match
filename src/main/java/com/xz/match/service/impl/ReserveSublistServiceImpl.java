package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.entity.ReserveSublistExample;
import java.util.List;
import java.util.Map;

import com.xz.match.mapper.ReserveSublistMapper;
import com.xz.match.entity.ReserveSublist;
import com.xz.match.service.ReserveSublistService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
@Service
@Transactional
public class ReserveSublistServiceImpl implements ReserveSublistService{

    @Resource
    private ReserveSublistMapper reserveSublistMapper;

    @Override
    public long countByExample(ReserveSublistExample example) {
        return reserveSublistMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReserveSublistExample example) {
        return reserveSublistMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return reserveSublistMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ReserveSublist record) {
        return reserveSublistMapper.insert(record);
    }

    @Override
    public int insertSelective(ReserveSublist record) {
        return reserveSublistMapper.insertSelective(record);
    }

    @Override
    public List<ReserveSublist> selectByExample(ReserveSublistExample example) {
        return reserveSublistMapper.selectByExample(example);
    }

    @Override
    public ReserveSublist selectByPrimaryKey(Long id) {
        return reserveSublistMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ReserveSublist record,ReserveSublistExample example) {
        return reserveSublistMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ReserveSublist record,ReserveSublistExample example) {
        return reserveSublistMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ReserveSublist record) {
        return reserveSublistMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReserveSublist record) {
        return reserveSublistMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ReserveSublist> findBy(Map<String, Object> map) {
        return reserveSublistMapper.findBy(map);
    }

}
