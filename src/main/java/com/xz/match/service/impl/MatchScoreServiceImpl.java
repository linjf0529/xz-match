package com.xz.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.MatchProductReceiveSet;
import com.xz.match.entity.SignRecord;
import com.xz.match.entity.vo.SignRecordScoreVO;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.MatchScore;
import com.xz.match.entity.MatchScoreExample;
import com.xz.match.mapper.MatchScoreMapper;
import com.xz.match.service.MatchScoreService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
@Transactional
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

    @Override
    public List<MatchScore> getMatchScoreList(Map<String, Object> map) {
        return matchScoreMapper.getMatchScoreList(map);
    }

    @Override
    public ResponseResult findSignRecordScore(PageParam pageParam, Map<String, Object> param) {
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
        List<SignRecordScoreVO> signRecordScoreVOs = matchScoreMapper.findSignRecordScore(param);
        return ResponseResult.ok().setData(new PageInfo<>(signRecordScoreVOs));
    }


}
