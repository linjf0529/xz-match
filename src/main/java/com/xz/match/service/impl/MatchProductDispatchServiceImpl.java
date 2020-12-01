package com.xz.match.service.impl;

import com.xz.match.entity.MatchDispatchSet;
import com.xz.match.entity.MatchProductDispatch;
import com.xz.match.entity.MatchProductDispatchExample;
import com.xz.match.entity.MatchProductReceiveSet;
import com.xz.match.entity.MatchProductSub;
import com.xz.match.entity.SignRecord;
import com.xz.match.entity.SignRecordFieldTable;
import com.xz.match.entity.vo.MatchProductDispatchInfoVO;
import com.xz.match.entity.vo.MatchProductDispatchVO;
import com.xz.match.entity.vo.MatchProductReceiveSetVO;
import com.xz.match.entity.vo.MatchStockVO;
import com.xz.match.mapper.MatchProductDispatchMapper;
import com.xz.match.mapper.MatchProductMapper;
import com.xz.match.mapper.MatchProductReceiveSetMapper;
import com.xz.match.mapper.MatchProductSubMapper;
import com.xz.match.service.MatchDispatchSetService;
import com.xz.match.service.MatchProductDispatchService;
import com.xz.match.service.MatchProductSubService;
import com.xz.match.service.SignRecordFieldTableService;
import com.xz.match.service.SignRecordService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.exception.CommonException;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
@Transactional
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
    @Resource
    private MatchDispatchSetService matchDispatchSetService;

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
     * @param phone
     * @return {@link ResponseResult}
     * @ 业务异常
     */
    @Override
    public ResponseResult findMatchProductDispatch(Long recordId, String phone)  {
        // 赛事报名信息
        SignRecord signRecord = signRecordService.selectByPrimaryKey(recordId);
        if(signRecord == null){
            throw new CommonException("选手不存在");
        }
        Long subjectId = signRecord.getSubjectId();
        Map paramMap = new HashMap();
        paramMap.put("recordId", recordId);
        List<SignRecordFieldTable> signRecordFieldTables = signRecordFieldTableService.findBy(paramMap);

        // 物资领取信息
        MatchProductReceiveSet matchProductReceiveSet = matchProductReceiveSetMapper.selectMatchProductReceiveSetBySubjectId(subjectId);
        MatchProductDispatchInfoVO matchProductDispatchInfoVO = new MatchProductDispatchInfoVO();
        matchProductDispatchInfoVO.setSignRecord(signRecord);
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
            signRecord.setSignRecordInfo(signRecordFieldTableList);
            // 1、物资发放信息
            matchProductDispatchInfoVO.setSignRecordInfo(matchProductReceiveSetVO);
        }
        //判断是否有发放权限
        List<MatchDispatchSet> matchDispatchSets = matchDispatchSetService.getModes(subjectId,phone);
        if(!matchDispatchSets.isEmpty()) {
            // 物资发放信息
            Map param = new HashMap();
            param.put("recordId", recordId);
            param.put("subjectId", subjectId);
            List<MatchProductDispatchVO> MatchProductDispatchVOList = matchProductDispatchMapper.selectMatchProductDispatchByRecordIdAndSubjectId(param);
            for (MatchProductDispatchVO matchProductDispatchVO : MatchProductDispatchVOList) {
                if (matchProductDispatchVO.getProductId() != null) {
                    int stockNum = 0;
                    List<MatchProductSub> MatchProductSubs = matchProductSubService.findMatchProductSubByProductId(matchProductDispatchVO.getProductId());
                    if (!CollectionUtils.isEmpty(MatchProductSubs)) {
                        matchProductDispatchVO.setMatchProductSubList(MatchProductSubs);
                        for (MatchProductSub matchProductSub : MatchProductSubs) {
                            stockNum = stockNum + (matchProductSub.getStockNumber() == null ? 0 : matchProductSub.getStockNumber().intValue());
                        }
                        matchProductDispatchVO.setStockNumber(stockNum+"");
                    }
                }
                Integer grantButton = 0;//发放按钮  0不展示发放按钮 1展示按钮 2展示置灰按钮
                if (matchProductDispatchVO.getId() == null) {
                    grantButton = 1;
                    if (Integer.parseInt(matchProductDispatchVO.getStockNumber()) == 0) {
                        grantButton = 2;
                    }
                }
                matchProductDispatchVO.setGrantButton(grantButton);
            }
            matchProductDispatchInfoVO.setMatchProductList(MatchProductDispatchVOList);
        }
        return ResponseResult.ok().setData(matchProductDispatchInfoVO);
    }

    /**
     * 添加发放信息
     *
     * @param matchProductDispatchVO 物资发放VO
     * @param currentUserName
     * @return {@link ResponseResult}
     * @ 业务异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult addMatchProductDispatch(MatchProductDispatchVO matchProductDispatchVO, String currentUserName)  {
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
            matchProductDispatchCount ++;
            if(MatchProductTotal == matchProductDispatchCount){
                // 已发放
                signRecord.setStatus(1);
            }else {
                // 部分发放
                signRecord.setStatus(2);
            }
            // 更新报名信息，物资发放的状态
            signRecordService.updateByPrimaryKeySelective(signRecord);
        }
        matchProductDispatch.setCreatedTime(System.currentTimeMillis());
        matchProductDispatch.setCreatedBy(currentUserName);
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
        List<Map<String, Object>>  maps = signRecordService.countSignRecordDispatchInfo(param);

        // 设定三个初始值，以便前端能显示物资发放状态情况
        List<Map<String, Object>>  originMaps = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            Map<String, Object> originMap = new HashMap<>();
            originMap.put("status",i);
            originMap.put("dispatchCount",0);
            originMaps.add(originMap);
        }

        if(!CollectionUtils.isEmpty(maps)){
            for(Map<String, Object> map:maps){
                for (Map<String, Object> originMap:originMaps){
                    if(map.get("status").equals(originMap.get("status"))){
                        originMap.put("dispatchCount",map.get("dispatchCount"));
                        break;
                    }
                }
            }
        }

        return ResponseResult.ok().setData(originMaps);

    }

    /**
     * 根据productId查询发放详情
     *
     * @param param 参数
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchProductDispatchInfoByProductId(Map<String, Object> param) {
        return ResponseResult.ok().setData(matchProductDispatchMapper.selectMatchProductDispatchInfoByProductId(param));
    }
}
