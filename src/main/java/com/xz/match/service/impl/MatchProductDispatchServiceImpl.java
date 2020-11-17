package com.xz.match.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.xz.match.entity.*;
import com.xz.match.entity.vo.MatchProductDispatchInfoVO;
import com.xz.match.entity.vo.MatchProductDispatchVO;
import com.xz.match.entity.vo.MatchProductReceiveSetVO;
import com.xz.match.entity.vo.MatchStockVO;
import com.xz.match.mapper.MatchProductMapper;
import com.xz.match.mapper.MatchProductReceiveSetMapper;
import com.xz.match.mapper.MatchProductSubMapper;
import com.xz.match.service.*;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.exception.CommonException;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xz.match.mapper.MatchProductDispatchMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchProductDispatchServiceImpl implements MatchProductDispatchService{

    @Resource
    private SignRecordFieldTableService signRecordFieldTableService;
    @Resource
    private MatchProductReceiveSetMapper matchProductReceiveSetMapper;

    @Resource
    private MatchProductDispatchMapper matchProductDispatchMapper;
    @Resource
    private MatchProductSubService matchProductSubService;
    @Resource
    private MatchProductSubMapper matchProductSubMapper;
    @Resource
    private MatchProductMapper matchProductMapper;
    @Resource
    private SignRecordService signRecordService;

    @Override
    public long countByExample(MatchProductDispatchExample example) {
        return matchProductDispatchMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchProductDispatchExample example) {
        return matchProductDispatchMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchProductDispatchMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchProductDispatch record) {
        return matchProductDispatchMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchProductDispatch record) {
        return matchProductDispatchMapper.insertSelective(record);
    }

    @Override
    public List<MatchProductDispatch> selectByExample(MatchProductDispatchExample example) {
        return matchProductDispatchMapper.selectByExample(example);
    }

    @Override
    public MatchProductDispatch selectByPrimaryKey(Long id) {
        return matchProductDispatchMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchProductDispatch record,MatchProductDispatchExample example) {
        return matchProductDispatchMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchProductDispatch record,MatchProductDispatchExample example) {
        return matchProductDispatchMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchProductDispatch record) {
        return matchProductDispatchMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchProductDispatch record) {
        return matchProductDispatchMapper.updateByPrimaryKey(record);
    }
    /**
     * 查找发放信息
     *
     * @param recordId  记录id
     * @param subjectId 对象id
     * @return {@link ResponseResult}
     * @ 业务异常
     */
    @Override
    public ResponseResult findMatchProductDispatch(Long recordId, Long subjectId)  {
        // 赛事报名信息
        Map paramMap = new HashMap();
        paramMap.put("recordId", recordId);
        List<SignRecordFieldTable> signRecordFieldTables = signRecordFieldTableService.findBy(paramMap);

        // 物资领取信息
        MatchProductReceiveSet matchProductReceiveSet = matchProductReceiveSetMapper.selectMatchProductReceiveSetBySubjectId(subjectId);

        MatchProductDispatchInfoVO matchProductDispatchInfoVO = new MatchProductDispatchInfoVO();
        // 比对物资领取配置信息，方便对APP物资领取信息页面控制
        MatchProductReceiveSetVO matchProductReceiveSetVO = new MatchProductReceiveSetVO();
        ValidateUtils.notNull(matchProductReceiveSet, "物资领取信息未配置");
        BeanUtils.copyProperties(matchProductReceiveSet, matchProductReceiveSetVO);

        List<SignRecordFieldTable> signRecordFieldTableList = Lists.newArrayList();
        if(StringUtils.isNotEmpty(matchProductReceiveSet.getPageShow())){
            String[] matchProductReceiveSetArr = matchProductReceiveSet.getPageShow().split(",");
            for (String matchProductReceiveSetStr:matchProductReceiveSetArr){
                for(SignRecordFieldTable signRecordFieldTable:signRecordFieldTables){
                    if(matchProductReceiveSetStr.trim().equals(signRecordFieldTable.getControlKey())){
                        signRecordFieldTableList.add(signRecordFieldTable);
                        continue;
                    }
                }
            }
            matchProductReceiveSetVO.setSignRecordFieldTables(signRecordFieldTableList);
            // 1、物资发放信息
            matchProductDispatchInfoVO.setSignRecordInfo(matchProductReceiveSetVO);
        }
        // 物资发放信息
        Map param= new HashMap();
        param.put("recordId", recordId);
        param.put("subjectId", subjectId);
        List<MatchProductDispatchVO> MatchProductDispatchVOList = matchProductDispatchMapper.selectMatchProductDispatchByRecordIdAndSubjectId(param);
        for(MatchProductDispatchVO matchProductDispatchVO : MatchProductDispatchVOList){
            if(matchProductDispatchVO.getProductId() != null){
                List<MatchProductSub> MatchProductSubs= matchProductSubService.findMatchProductSubByProductId(matchProductDispatchVO.getProductId());
                if(!CollectionUtils.isEmpty(MatchProductSubs)){
                    matchProductDispatchVO.setMatchProductSubList(MatchProductSubs);
                }
            }
        }
        matchProductDispatchInfoVO.setMatchProductList(MatchProductDispatchVOList);
        return ResponseResult.ok().setData(matchProductDispatchInfoVO);
    }

    /**
     * 添加发放信息
     *
     * @param matchProductDispatchVO 物资发放VO
     * @return {@link ResponseResult}
     * @ 业务异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult addMatchProductDispatch(MatchProductDispatchVO matchProductDispatchVO)  {
        MatchProductDispatch matchProductDispatch = new MatchProductDispatch();
        BeanUtils.copyProperties(matchProductDispatchVO, matchProductDispatch);

        // 要扣减库存 子项库存和总库存
        if (matchProductDispatchVO.getProductSubId() != null){
            MatchProductSub matchProductSub = new MatchProductSub();
            matchProductSub.setId(matchProductDispatchVO.getProductSubId());
            matchProductSub.setStockNumber(1L);
            // 减子库存
            int stockNumber = matchProductSubMapper.updateToMinusMatchStockByProductSubId(matchProductSub);
            // 同时扣减子项库存，须同时满足扣减
            if(stockNumber == 0){
                throw new CommonException(matchProductDispatchVO.getProductSubName()+"扣减库存不足");
            }
        }else {
            MatchStockVO matchStockVO = new MatchStockVO();
            matchStockVO.setProductId(matchProductDispatchVO.getProductId());
            matchStockVO.setStockNumber(1L);
            // 减库存
            int stockNumber = matchProductMapper.updateToMinusMatchStockByProductId(matchStockVO);
        }

        // 更新发放状态
        Map param= new HashMap();
        param.put("recordId", matchProductDispatchVO.getRecordId());
        param.put("subjectId", matchProductDispatchVO.getSubjectId());
        List<MatchProductDispatchVO> MatchProductDispatchVOList = matchProductDispatchMapper.selectMatchProductDispatchByRecordIdAndSubjectId(param);
        if(!CollectionUtils.isEmpty(MatchProductDispatchVOList)){
            int MatchProductTotal = MatchProductDispatchVOList.size();
            int matchProductDispatchCount = 0;
            for(MatchProductDispatchVO matchProductDispatchInfo:MatchProductDispatchVOList){
                if(matchProductDispatchInfo.getId() != null){
                    matchProductDispatchCount++;
                }
            }
            // 2-部分发放，1-已发放，0-未发放
            SignRecord signRecord = new SignRecord();
            signRecord.setId(matchProductDispatchVO.getRecordId());

            if(MatchProductTotal == matchProductDispatchCount){
                // 已发放
                signRecord.setStatus(1);
            }else if(matchProductDispatchCount == 0) {
                // 未发放
                signRecord.setStatus(0);
            }else {
                // 部分发放
                signRecord.setStatus(2);
            }
            // 更新报名信息，物资发放的状态
            signRecordService.updateByPrimaryKeySelective(signRecord);
        }
        return ResponseResult.ok().setData(this.insertSelective(matchProductDispatch));
    }

    /**
     * 统计参赛人员的物资发放状态
     *
     * @param param 参数
     * @return {@link ResponseResult}
     * @ 业务异常
     */
    @Override
    public ResponseResult findSignRecordDispatchInfo(Map<String, Object> param)  {
        return ResponseResult.ok().setData(signRecordService.countSignRecordDispatchInfo(param));
    }
}