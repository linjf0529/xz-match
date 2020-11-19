package com.xz.match.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.vo.ReserveInfoVO;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.entity.ReserveInfo;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.ReserveInfoExample;
import com.xz.match.mapper.ReserveInfoMapper;
import com.xz.match.service.ReserveInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
@Service
@Transactional
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

    @Override
    public ResponseResult findBy(PageParam pageParam, Map<String, Object> param) {
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
        List<ReserveInfoVO> reserveInfoVOS = reserveInfoMapper.findBy(param);
        return ResponseResult.ok().setData(new PageInfo<>(reserveInfoVOS));
    }

    /**
     * 获取导航信息
     *
     * @param subjectId
     * @return
     */
    @Override
    public ReserveInfo getLocalInfo(Long subjectId) {
        ReserveInfoExample reserveInfoExample = new ReserveInfoExample();
        reserveInfoExample.createCriteria().andSubjectIdEqualTo(subjectId);
        List<ReserveInfo> reserveInfos = this.selectByExample(reserveInfoExample);
        if(!reserveInfos.isEmpty()){
            return reserveInfos.get(0);
        }
        return null;
    }
}
