package com.xz.match.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.vo.MatchDispatchPermissionVO;
import com.xz.match.entity.vo.MatchDispatchSetVO;
import com.xz.match.service.UserInfoService;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
@Transactional
public class MatchDispatchSetServiceImpl implements MatchDispatchSetService{

    @Resource
    private MatchDispatchSetMapper matchDispatchSetMapper;
    @Resource
    private UserInfoService userInfoService;

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
     * @param param     参数
     * @param subjectId 对象id
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchDispatchSetByPhone(String subjectId,Map<String, Object> param){
        List<MatchDispatchSet> MatchDispatchSetList= this.matchDispatchSetMapper.findBy(param);
        if(!CollectionUtils.isEmpty(MatchDispatchSetList)){
            MatchDispatchSet matchDispatchSet = MatchDispatchSetList.get(0);
            if(matchDispatchSet == null){
                throw new CommonException("该手机号未配置权限");
            }
            if(StringUtils.isNotBlank(matchDispatchSet.getPermission())){
                if(!matchDispatchSet.getPermission().contains(subjectId)){
                    throw new CommonException("该手机号无权限");
                }
            }
            return ResponseResult.ok().setData(MatchDispatchSetList.get(0));
        }
        return ResponseResult.ok().setData(new MatchDispatchSet());
    }
    /**
     * 找到发放人员配置
     *
     *
     * @param params    参数个数
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchDispatchSet(PageParam pageParam,Map<String, Object> params) {
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
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
        userInfoService.saveUser(matchDispatchSetVO.getMobile(),null,matchDispatchSetVO.getName(), 1);
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

    /**
     * 修改发放人员配置
     *
     * @param matchDispatchSetVO
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult modifyMatchDispatchSet(MatchDispatchSetVO matchDispatchSetVO) {
        MatchDispatchSet matchDispatchSet =new MatchDispatchSet();
        BeanUtils.copyProperties(matchDispatchSetVO, matchDispatchSet);
        Map param = new HashMap();
        param.put("mobile", matchDispatchSetVO.getMobile());
        List<MatchDispatchSet> matchDispatchSetes= matchDispatchSetMapper.findBy(param);
        if(!matchDispatchSetes.isEmpty()){
            throw new CommonException("手机号已存在");
        }
        int count = this.updateByPrimaryKeySelective(matchDispatchSet);
        if(count > 0){
            userInfoService.saveUser(matchDispatchSetVO.getMobile(),null,matchDispatchSetVO.getName(), 1);
        }
        return ResponseResult.ok().setData(matchDispatchSet);
    }

    /**
     * 查找发放人员配置的权限
     *
     * @return {@link JSONArray}
     */
    private JSONArray findMatchDispatchPermissionByTenantId()  {
        List<MatchDispatchPermissionVO> matchDispatchPermissionVOList = matchDispatchSetMapper.selectMatchDispatchPermission();
        String  matchDispatchPermissionStr = null;
        if(!CollectionUtils.isEmpty(matchDispatchPermissionVOList)){
            matchDispatchPermissionStr = JSON.toJSONString(matchDispatchPermissionVOList).replaceAll("childrenId","id").replaceAll("childrenLabel","label");
        }
        return JSON.parseArray(matchDispatchPermissionStr);
    }

    /**
     * 根据id查找发放人员配置
     *
     * @param params 参数个数
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchDispatchSetById(Map<String, Object> params)  {
        MatchDispatchSetVO matchDispatchSetVO = new MatchDispatchSetVO();
        if(params.get("id") != null){
            MatchDispatchSet matchDispatchSet = matchDispatchSetMapper.selectByPrimaryKey(Long.valueOf(params.get("id").toString()));
            if(!ObjectUtils.isEmpty(matchDispatchSet)){
                BeanUtils.copyProperties(matchDispatchSet, matchDispatchSetVO);
            }
        }
        // 权限
        matchDispatchSetVO.setMatchDispatchPermission(this.findMatchDispatchPermissionByTenantId());
        return ResponseResult.ok().setData(matchDispatchSetVO);
    }

    @Override
    public List<MatchDispatchSet> getModes(Long subjectId, String phone) {
        Map<String,Object> param = new HashMap<>();
        param.put("permissionId",subjectId);
        param.put("mobile",phone);
        return matchDispatchSetMapper.findBy(param);
    }
}
