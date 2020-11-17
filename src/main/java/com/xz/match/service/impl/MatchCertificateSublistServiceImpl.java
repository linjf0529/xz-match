package com.xz.match.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.mapper.MatchCertificateSublistMapper;
import java.util.List;
import com.xz.match.entity.MatchCertificateSublistExample;
import com.xz.match.entity.MatchCertificateSublist;
import com.xz.match.service.MatchCertificateSublistService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
@Transactional
public class MatchCertificateSublistServiceImpl implements MatchCertificateSublistService{

    @Resource
    private MatchCertificateSublistMapper matchCertificateSublistMapper;

    @Override
    public long countByExample(MatchCertificateSublistExample example) {
        return matchCertificateSublistMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchCertificateSublistExample example) {
        return matchCertificateSublistMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchCertificateSublistMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchCertificateSublist record) {
        return matchCertificateSublistMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchCertificateSublist record) {
        return matchCertificateSublistMapper.insertSelective(record);
    }

    @Override
    public List<MatchCertificateSublist> selectByExample(MatchCertificateSublistExample example) {
        return matchCertificateSublistMapper.selectByExample(example);
    }

    @Override
    public MatchCertificateSublist selectByPrimaryKey(Long id) {
        return matchCertificateSublistMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchCertificateSublist record,MatchCertificateSublistExample example) {
        return matchCertificateSublistMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchCertificateSublist record,MatchCertificateSublistExample example) {
        return matchCertificateSublistMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchCertificateSublist record) {
        return matchCertificateSublistMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchCertificateSublist record) {
        return matchCertificateSublistMapper.updateByPrimaryKey(record);
    }

}
