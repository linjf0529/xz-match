package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.mapper.MatchImageMapper;
import java.util.List;
import com.xz.match.entity.MatchImage;
import com.xz.match.entity.MatchImageExample;
import com.xz.match.service.MatchImageService;
/**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
@Service
public class MatchImageServiceImpl implements MatchImageService{

    @Resource
    private MatchImageMapper matchImageMapper;

    @Override
    public long countByExample(MatchImageExample example) {
        return matchImageMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchImageExample example) {
        return matchImageMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchImage record) {
        return matchImageMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchImage record) {
        return matchImageMapper.insertSelective(record);
    }

    @Override
    public List<MatchImage> selectByExample(MatchImageExample example) {
        return matchImageMapper.selectByExample(example);
    }

    @Override
    public MatchImage selectByPrimaryKey(Long id) {
        return matchImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchImage record,MatchImageExample example) {
        return matchImageMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchImage record,MatchImageExample example) {
        return matchImageMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchImage record) {
        return matchImageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchImage record) {
        return matchImageMapper.updateByPrimaryKey(record);
    }

}
