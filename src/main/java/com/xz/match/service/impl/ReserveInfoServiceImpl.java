package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.entity.ReserveInfo;
import java.util.List;
import com.xz.match.entity.ReserveInfoExample;
import com.xz.match.mapper.ReserveInfoMapper;
import com.xz.match.service.ReserveInfoService;
/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
@Service
public class ReserveInfoServiceImpl implements ReserveInfoService{

    @Resource
    private ReserveInfoMapper reserveInfoMapper;

    @Override
    public long countByExample(ReserveInfoExample example) {
        return reserveInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReserveInfoExample example) {
        return reserveInfoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return reserveInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ReserveInfo record) {
        return reserveInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ReserveInfo record) {
        return reserveInfoMapper.insertSelective(record);
    }

    @Override
    public List<ReserveInfo> selectByExample(ReserveInfoExample example) {
        return reserveInfoMapper.selectByExample(example);
    }

    @Override
    public ReserveInfo selectByPrimaryKey(Long id) {
        return reserveInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ReserveInfo record,ReserveInfoExample example) {
        return reserveInfoMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ReserveInfo record,ReserveInfoExample example) {
        return reserveInfoMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ReserveInfo record) {
        return reserveInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReserveInfo record) {
        return reserveInfoMapper.updateByPrimaryKey(record);
    }

}
