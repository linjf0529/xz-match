package com.xz.match.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.vo.MatchDispatchSetVO;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.exception.CommonException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.MatchDispatchSet;
import com.xz.match.mapper.MatchDispatchSetMapper;
import com.xz.match.entity.MatchDispatchSetExample;
import com.xz.match.service.MatchDispatchSetService;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchDispatchSetServiceImpl implements MatchDispatchSetService{

    @Resource
    private MatchDispatchSetMapper matchDispatchSetMapper;

    @Override
    public long countByExample(MatchDispatchSetExample example) {
        return matchDispatchSetMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchDispatchSetExample example) {
        return matchDispatchSetMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchDispatchSetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchDispatchSet record) {
        return matchDispatchSetMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchDispatchSet record) {
        return matchDispatchSetMapper.insertSelective(record);
    }

    @Override
    public List<MatchDispatchSet> selectByExample(MatchDispatchSetExample example) {
        return matchDispatchSetMapper.selectByExample(example);
    }

    @Override
    public MatchDispatchSet selectByPrimaryKey(Long id) {
        return matchDispatchSetMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchDispatchSet record,MatchDispatchSetExample example) {
        return matchDispatchSetMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchDispatchSet record,MatchDispatchSetExample example) {
        return matchDispatchSetMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchDispatchSet record) {
        return matchDispatchSetMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchDispatchSet record) {
        return matchDispatchSetMapper.updateByPrimaryKey(record);
    }

    /**
     * 通过电话查询发放人员配置
     *
     * @param param 参数
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchDispatchSetByPhone(Map<String, Object> param){
        return ResponseResult.ok().setData(this.matchDispatchSetMapper.findBy(param).get(0));
    }
    /**
     * 找到发放人员配置
     *
     *
     * @param params    参数个数
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchDispatchSet(Map<String, Object> params) {
        PageHelper.startPage(2, 2);
        List<MatchDispatchSet> matchDispatchSets = this.matchDispatchSetMapper.findBy(params);
        return ResponseResult.ok().setData(new PageInfo<>(matchDispatchSets));
    }

    /**
     * 添加发放人员配置
     *
     * @param matchDispatchSetVO 发放人员配置VO
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult addMatchDispatchSet(MatchDispatchSetVO matchDispatchSetVO){
        MatchDispatchSet matchDispatchSet =new MatchDispatchSet();
        BeanUtils.copyProperties(matchDispatchSetVO, matchDispatchSet);
        // 项目手机号要去重
        if(StringUtils.isNotBlank(matchDispatchSetVO.getMobile())){
            Map param = new HashMap();
            param.put("mobile", matchDispatchSetVO.getMobile());
            List<MatchDispatchSet> matchDispatchSetes= matchDispatchSetMapper.findBy(param);
            if(!matchDispatchSetes.isEmpty()){
                throw new CommonException("手机号已存在");
            }
        }
        return ResponseResult.ok().setData(this.insertSelective(matchDispatchSet));
    }


    /**
     * 删除发放人员配置
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult removeMatchDispatchSet(Long id){
        this.deleteByPrimaryKey(id);
        return ResponseResult.ok();
    }
}
