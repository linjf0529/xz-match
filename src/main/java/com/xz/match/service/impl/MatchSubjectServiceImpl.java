package com.xz.match.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.xz.match.entity.MatchSubjectExample;
import com.xz.match.mapper.MatchSubjectMapper;
import com.xz.match.entity.MatchSubject;
import com.xz.match.service.MatchSubjectService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenwf
 * @date 2020/11/16
 */
@Service
@Transactional
public class MatchSubjectServiceImpl implements MatchSubjectService {

    @Resource
    private MatchSubjectMapper matchSubjectMapper;

    @Override
    public long countByExample(MatchSubjectExample example) {
        return matchSubjectMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchSubjectExample example) {
        return matchSubjectMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchSubjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchSubject record) {
        return matchSubjectMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchSubject record) {
        return matchSubjectMapper.insertSelective(record);
    }

    @Override
    public List<MatchSubject> selectByExample(MatchSubjectExample example) {
        return matchSubjectMapper.selectByExample(example);
    }

    @Override
    public MatchSubject selectByPrimaryKey(Long id) {
        return matchSubjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchSubject record, MatchSubjectExample example) {
        return matchSubjectMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(MatchSubject record, MatchSubjectExample example) {
        return matchSubjectMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchSubject record) {
        return matchSubjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchSubject record) {
        return matchSubjectMapper.updateByPrimaryKey(record);
    }

    /**
     * 赛事对应科目
     *
     * @param matchId
     * @return
     */
    @Override
    public ResponseResult findSubjectByMatchId(Long matchId) {
        MatchSubjectExample matchSubjectExample = new MatchSubjectExample();
        matchSubjectExample.createCriteria().andMatchIdEqualTo(matchId);
        return ResponseResult.ok().setData(this.selectByExample(matchSubjectExample));
    }

    @Override
    public ResponseResult allSubject(PageParam pageParam, JSONObject param) {
        PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
        List<MatchSubject> matchSubjects = matchSubjectMapper.findBy(param);
        return ResponseResult.ok().setData(new PageInfo<>(matchSubjects));
    }
}

