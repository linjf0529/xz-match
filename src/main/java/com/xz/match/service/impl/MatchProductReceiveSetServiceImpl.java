package com.xz.match.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.*;
import com.xz.match.entity.vo.MatchProductReceiveSetVO;
import com.xz.match.mapper.MatchProductReceiveSetMapper;
import com.xz.match.service.*;
import com.xz.match.utils.CodeUtils;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.exception.CommonException;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
public class MatchProductReceiveSetServiceImpl implements MatchProductReceiveSetService{

    @Resource
    private MatchProductReceiveSetMapper matchProductReceiveSetMapper;

    @Resource
    private SignRecordFieldTableService signRecordFieldTableService;

    @Resource
    private SubjectSignFieldService subjectSignFieldService;

    @Resource
    private MatchProductService matchProductService;

    @Resource
    private SignRecordService signRecordService;

    @Override
    public long countByExample(MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchProductReceiveSetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchProductReceiveSet record) {
        return matchProductReceiveSetMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchProductReceiveSet record) {
        return matchProductReceiveSetMapper.insertSelective(record);
    }

    @Override
    public List<MatchProductReceiveSet> selectByExample(MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.selectByExample(example);
    }

    @Override
    public MatchProductReceiveSet selectByPrimaryKey(Long id) {
        return matchProductReceiveSetMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchProductReceiveSet record,MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchProductReceiveSet record,MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchProductReceiveSet record) {
        return matchProductReceiveSetMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchProductReceiveSet record) {
        return matchProductReceiveSetMapper.updateByPrimaryKey(record);
    }

    /**
     * 查找所有个人项目
     *
     * @param pageParam 页面参数
     * @param param     参数
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchProductReceiveSet(PageParam pageParam, Map<String, Object> param)  {
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
        List<MatchProductReceiveSet> matchProductReceiveSets = matchProductReceiveSetMapper.findBy(param);
        return ResponseResult.ok().setData(new PageInfo<>(matchProductReceiveSets));
    }

    /**
     * 找到匹配的产品获得设定的对象id
     *
     * @param param 参数
     * @return {@link MatchProductReceiveSetVO}
     */
    @Override
    public MatchProductReceiveSetVO findMatchProductReceiveSetBySubjectId(Map<String, Object> param)  {
        MatchProductReceiveSetVO matchProductReceiveSetVO = new MatchProductReceiveSetVO();
        // 展示参数:报名字段
        List<SubjectSignField> dataList = subjectSignFieldService.findBy(param);
        matchProductReceiveSetVO.setSubjectSignFields(dataList);

        // 物资领取配置信息 |——每个赛事项目只有一条配置信息
        MatchProductReceiveSet matchProductReceiveSet = matchProductReceiveSetMapper.selectMatchProductReceiveSetBySubjectId(Long.parseLong(param.get("subjectId").toString()));
        if(matchProductReceiveSet != null){
            BeanUtils.copyProperties(matchProductReceiveSet, matchProductReceiveSetVO);
        }else {
            // 默认姓名和手机号要勾选上
            matchProductReceiveSetVO.setPageShow("sf734362,sf928984626");
        }
        return matchProductReceiveSetVO;
    }

    /**
     * 修改物资领取配置
     *
     * @param matchProductReceiveSetVO 物资领取配置VO
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult modifyMatchProductReceiveSet(MatchProductReceiveSetVO matchProductReceiveSetVO)  {
        MatchProductReceiveSet matchProductReceiveSet = new MatchProductReceiveSet();
        BeanUtils.copyProperties(matchProductReceiveSetVO, matchProductReceiveSet);
        // 场景：新增和修改在同一页面
        return ResponseResult.ok().setData(this.insertSelective(matchProductReceiveSet));
    }

    /**
     * 根据报名记录id和科目id查询物资领取信息
     *
     * @param recordId  记录id
     * @param subjectId 对象id
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchProductReceiveSetByRecordIdAndSubjectId(Long recordId, Long subjectId)  {
        // 赛事报名信息
        Map paramMap = new HashMap();
        paramMap.put("recordId", recordId);
        List<SignRecordFieldTable> signRecordFieldTables = signRecordFieldTableService.findBy(paramMap);

        // 物资领取信息
        MatchProductReceiveSet matchProductReceiveSet = matchProductReceiveSetMapper.selectMatchProductReceiveSetBySubjectId(subjectId);

        // 比对物资领取配置信息，方便对APP物资领取信息页面控制
        MatchProductReceiveSetVO matchProductReceiveSetVO = new MatchProductReceiveSetVO();
        ValidateUtils.notNull(matchProductReceiveSet, "物资领取信息未配置");
        BeanUtils.copyProperties(matchProductReceiveSet, matchProductReceiveSetVO);

        List<SignRecordFieldTable> signRecordFieldTableList = Lists.newArrayList();
        if(!StringUtils.isEmpty(matchProductReceiveSet.getPageShow())){
            String[] matchProductReceiveSetArr = matchProductReceiveSet.getPageShow().split(",");
            for (String matchProductReceiveSetSrt:matchProductReceiveSetArr){
                for(SignRecordFieldTable signRecordFieldTable:signRecordFieldTables){
                    if(matchProductReceiveSetSrt.trim().equals(signRecordFieldTable.getControlKey())){
                        signRecordFieldTableList.add(signRecordFieldTable);
                        continue;
                    }
                }
            }
            matchProductReceiveSetVO.setSignRecordFieldTables(signRecordFieldTableList);
        }

        // 赛事物资清单
        Map param = new HashMap();
        param.put("subjectId", subjectId);
        List<MatchProduct> matchProduct = matchProductService.findBy(param);
        matchProductReceiveSetVO.setMatchProducts(matchProduct);
        return ResponseResult.ok().setData(matchProductReceiveSetVO);
    }

    @Override
    public void getBarCode(Long subjectId, Long userId, HttpServletResponse response) {
        JSONObject param = new JSONObject();
        param.put("userId",userId);
        param.put("subjectId",subjectId);
        List<SignRecord> signRecords = signRecordService.findBy(param);
        if(signRecords.isEmpty()){
            throw new CommonException("未找到该选手的报名信息");
        }
        StringBuffer sb = new StringBuffer();
        sb.append("www.baidu.com");
        sb.append("?subjectId="+subjectId);
        sb.append("&recordId="+signRecords.get(0).getId());
        CodeUtils.creatRrCode(sb.toString(),250,250,response);
    }
}
