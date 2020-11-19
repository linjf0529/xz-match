package com.xz.match.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.utils.ResponseResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.xz.match.mapper.MatchScoreConfigMapper;
import com.xz.match.entity.MatchScoreConfigExample;
import com.xz.match.entity.MatchScoreConfig;
import com.xz.match.service.MatchScoreConfigService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
@Transactional
public class MatchScoreConfigServiceImpl implements MatchScoreConfigService{

    @Resource
    private MatchScoreConfigMapper matchScoreConfigMapper;

    @Override
    public long countByExample(MatchScoreConfigExample example) {
        return matchScoreConfigMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchScoreConfigExample example) {
        return matchScoreConfigMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchScoreConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchScoreConfig record) {
        return matchScoreConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchScoreConfig record) {
        return matchScoreConfigMapper.insertSelective(record);
    }

    @Override
    public List<MatchScoreConfig> selectByExample(MatchScoreConfigExample example) {
        return matchScoreConfigMapper.selectByExample(example);
    }

    @Override
    public MatchScoreConfig selectByPrimaryKey(Long id) {
        return matchScoreConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchScoreConfig record,MatchScoreConfigExample example) {
        return matchScoreConfigMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchScoreConfig record,MatchScoreConfigExample example) {
        return matchScoreConfigMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchScoreConfig record) {
        return matchScoreConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchScoreConfig record) {
        return matchScoreConfigMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MatchScoreConfig> findBy(Map<String, Object> map) {
        return matchScoreConfigMapper.findBy(map);
    }

    @Override
    public ResponseResult save(MatchScoreConfig matchScoreConfig) {
        Integer sort=matchScoreConfigMapper.getMaxSort(matchScoreConfig.getSubjectId());
        if(sort==null){
            sort=1;
        }else {
            sort=sort+1;
        }
        matchScoreConfig.setSort(sort);
        int cuont;
        matchScoreConfig.setType(2);
        matchScoreConfig.setShowState(1);
        if(matchScoreConfig.getId()!=null&&matchScoreConfig.getId()!=0){
            cuont=matchScoreConfigMapper.updateByPrimaryKeySelective(matchScoreConfig);
        }else {
            cuont=matchScoreConfigMapper.insert(matchScoreConfig);
        }
        return ResponseResult.ok().setData(cuont);
    }


}
