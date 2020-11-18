package com.xz.match.service.impl;

import com.xz.match.entity.MatchInfoExample;
import com.xz.match.entity.MatchSubject;
import com.xz.match.entity.MatchSubjectExample;
import com.xz.match.utils.ResponseResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import com.xz.match.mapper.MatchInfoMapper;
import com.xz.match.entity.MatchInfo;
import com.xz.match.service.MatchInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenwf
 * @date 2020/11/16
 */
@Service
@Transactional
public class MatchInfoServiceImpl implements MatchInfoService {

    @Resource
    private MatchInfoMapper matchInfoMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return matchInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchInfo record) {
        return matchInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchInfo record) {
        return matchInfoMapper.insertSelective(record);
    }

    @Override
    public MatchInfo selectByPrimaryKey(String id) {
        return matchInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchInfo record) {
        return matchInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchInfo record) {
        return matchInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<MatchInfo> list) {
        return matchInfoMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<MatchInfo> list) {
        return matchInfoMapper.batchInsert(list);
    }

    @Override
    public List<MatchInfo> get() {
        MatchInfo matchInfo = new MatchInfo();
        matchInfo.setMatchName("测试");
        matchInfoMapper.insertSelective(matchInfo);
        return selectByExample(new MatchInfoExample());
    }

    @Override
    public long countByExample(MatchInfoExample example) {
        return matchInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchInfoExample example) {
        return matchInfoMapper.deleteByExample(example);
    }

    @Override
    public List<MatchInfo> selectByExample(MatchInfoExample example) {
        return matchInfoMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(MatchInfo record, MatchInfoExample example) {
        return matchInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(MatchInfo record, MatchInfoExample example) {
        return matchInfoMapper.updateByExample(record, example);
    }

    /**
     * 找出所有赛事
     * @return
     */
    @Override
    public ResponseResult allMatch() {
        return ResponseResult.ok().setData(this.selectByExample(new MatchInfoExample()));
    }

}








