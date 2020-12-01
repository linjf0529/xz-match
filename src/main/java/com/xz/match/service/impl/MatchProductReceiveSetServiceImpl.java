package com.xz.match.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.MatchProduct;
import com.xz.match.entity.MatchProductReceiveSet;
import com.xz.match.entity.MatchProductReceiveSetExample;
import com.xz.match.entity.MatchSubject;
import com.xz.match.entity.SignRecord;
import com.xz.match.entity.SignRecordFieldTable;
import com.xz.match.entity.SubjectSignField;
import com.xz.match.entity.vo.MatchProductReceiveSetVO;
import com.xz.match.mapper.MatchProductReceiveSetMapper;
import com.xz.match.service.MatchDispatchSetService;
import com.xz.match.service.MatchProductReceiveSetService;
import com.xz.match.service.MatchProductService;
import com.xz.match.service.MatchSubjectService;
import com.xz.match.service.SignRecordFieldTableService;
import com.xz.match.service.SignRecordService;
import com.xz.match.service.SubjectSignFieldService;
import com.xz.match.utils.CodeUtils;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.exception.CommonException;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
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
    private MatchSubjectService matchSubjectService;

    @Resource
    private SignRecordService signRecordService;

    @Resource
    private MatchDispatchSetService matchDispatchSetService;

    @Value("${match.h5.url}")
    public String MATCH_H5_HOST;

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
    public int updateByExampleSelective(MatchProductReceiveSet record, MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(MatchProductReceiveSet record, MatchProductReceiveSetExample example) {
        return matchProductReceiveSetMapper.updateByExample(record, example);
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
    public ResponseResult findMatchProductReceiveSet(PageParam pageParam, Map<String, Object> param) {
        PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
        List<MatchProductReceiveSetVO> matchProductReceiveSets = matchProductReceiveSetMapper.findBy(param);
        PageInfo<MatchProductReceiveSetVO> pageInfo = new PageInfo<>(matchProductReceiveSets);
        for (MatchProductReceiveSetVO matchProductReceiveSet : pageInfo.getList()) {
            StringBuffer sb = new StringBuffer();
            sb.append(MATCH_H5_HOST + "/home");
            sb.append("?subjectId=" + matchProductReceiveSet.getId());
            sb.append("&matchId=" + matchProductReceiveSet.getMatchId());
            sb.append("&type=2");
            matchProductReceiveSet.setRecordUrl(sb.toString());
        }
        return ResponseResult.ok().setData(pageInfo);
    }

    /**
     * 找到匹配的产品获得设定的对象id
     *
     * @param param 参数
     * @return {@link MatchProductReceiveSetVO}
     */
    @Override
    public MatchProductReceiveSetVO findMatchProductReceiveSetBySubjectId(Map<String, Object> param) {
        MatchProductReceiveSetVO matchProductReceiveSetVO = new MatchProductReceiveSetVO();
        // 展示参数:报名字段
        List<SubjectSignField> dataList = subjectSignFieldService.findBy(param);
        matchProductReceiveSetVO.setSubjectSignFields(dataList);

        // 物资领取配置信息 |——每个赛事项目只有一条配置信息
        MatchProductReceiveSet matchProductReceiveSet = matchProductReceiveSetMapper.selectMatchProductReceiveSetBySubjectId(Long.parseLong(param.get("subjectId").toString()));
        if (matchProductReceiveSet != null) {
            BeanUtils.copyProperties(matchProductReceiveSet, matchProductReceiveSetVO);
        } else {
            MatchSubject matchSubject  = matchSubjectService.selectByPrimaryKey(Long.parseLong(param.get("subjectId").toString()));
            if(matchSubject != null){
                matchProductReceiveSetVO.setSubjectId(matchSubject.getId());
                matchProductReceiveSetVO.setSubjectName(matchSubject.getSubjectName());
                matchProductReceiveSetVO.setMatchId(matchSubject.getMatchId());
                matchProductReceiveSetVO.setMatchName(matchSubject.getMatchName());
            }
            // 默认姓名和手机号要勾选上
            matchProductReceiveSetVO.setPageShow("sf734362,sf25022344");
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
    public ResponseResult modifyMatchProductReceiveSet(MatchProductReceiveSetVO matchProductReceiveSetVO) {
        MatchProductReceiveSet matchProductReceiveSet = new MatchProductReceiveSet();
        BeanUtils.copyProperties(matchProductReceiveSetVO, matchProductReceiveSet);
        // 场景：新增和修改在同一页面
        if(matchProductReceiveSet.getId() == null){
            this.insertSelective(matchProductReceiveSet);
        }else{
            this.updateByPrimaryKeySelective(matchProductReceiveSet);
        }
        return ResponseResult.ok().setData(matchProductReceiveSet);
    }

    /**
     * 根据报名记录id和科目id查询物资领取信息
     *
     * @param playerUserId 选手用户id
     * @param subjectId    对象id
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchProductReceiveSetByRecordIdAndSubjectId(Long playerUserId, Long subjectId) {
        // 赛事报名信息
        JSONObject signParam = new JSONObject();
        signParam.put("subjectId", subjectId);
        signParam.put("userId", playerUserId);
        List<SignRecord> signRecords = signRecordService.findBy(signParam);
        if (signRecords.isEmpty()) {
            throw new CommonException("未找到该报名选手的信息");
        }
        SignRecord signRecord = signRecords.get(0);
        Map paramMap = new HashMap();
        paramMap.put("recordId", signRecords.get(0).getId());
        List<SignRecordFieldTable> signRecordFieldTables = signRecordFieldTableService.findBy(paramMap);

        // 物资领取信息
        MatchProductReceiveSet matchProductReceiveSet = matchProductReceiveSetMapper.selectMatchProductReceiveSetBySubjectId(subjectId);

        // 比对物资领取配置信息，方便对APP物资领取信息页面控制
        MatchProductReceiveSetVO matchProductReceiveSetVO = new MatchProductReceiveSetVO();
        ValidateUtils.notNull(matchProductReceiveSet, "物资领取信息未配置");
        BeanUtils.copyProperties(matchProductReceiveSet, matchProductReceiveSetVO);

        List<SignRecordFieldTable> signRecordFieldTableList = Lists.newArrayList();
        if (!StringUtils.isEmpty(matchProductReceiveSet.getPageShow())) {
            String[] matchProductReceiveSetArr = matchProductReceiveSet.getPageShow().split(",");
            for (String matchProductReceiveSetSrt : matchProductReceiveSetArr) {
                for (SignRecordFieldTable signRecordFieldTable : signRecordFieldTables) {
                    if (matchProductReceiveSetSrt.trim().equals(signRecordFieldTable.getControlKey())) {
                        signRecordFieldTableList.add(signRecordFieldTable);
                        continue;
                    }
                }
            }
            signRecord.setSignRecordInfo(signRecordFieldTableList);
            matchProductReceiveSetVO.setSignRecord(signRecord);
            matchProductReceiveSetVO.setSignRecordFieldTables(signRecordFieldTableList);
        }

        // 赛事物资清单
        Map param = new HashMap();
        param.put("subjectId", subjectId);
        List<MatchProduct> matchProducts = matchProductService.findBy(param);
        matchProductReceiveSetVO.setMatchProducts(matchProducts);
        return ResponseResult.ok().setData(matchProductReceiveSetVO);
    }

    @Override
    public void getBarCode(Long subjectId, Long userId, HttpServletResponse response) {
        JSONObject param = new JSONObject();
        param.put("userId", userId);
        param.put("subjectId", subjectId);
        List<SignRecord> signRecords = signRecordService.findBy(param);
        if (signRecords.isEmpty()) {
            throw new CommonException("未找到该选手的报名信息");
        }
//        StringBuffer sb = new StringBuffer();
//        sb.append(MATCH_H5_HOST + "/suppliesIssue");
//        sb.append("?subjectId=" + subjectId);
//        sb.append("&recordId=" + signRecords.get(0).getId());
//        CodeUtils.creatRrCode(sb.toString(), 250, 250, response);
        CodeUtils.getBarCode(signRecords.get(0).getId().toString(),response);
    }

    /**
     * 下载赛事科目二维码
     *
     * @param subjectId
     * @param matchId
     * @param response
     */
    @Override
    public void downloadBarCode(Long subjectId, Long matchId, HttpServletResponse response) {
        StringBuffer sb = new StringBuffer();
        sb.append(MATCH_H5_HOST + "/home");
        sb.append("?subjectId=" + subjectId);
        sb.append("&matchId=" + matchId);
        sb.append("&type=2");
        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;filename=matchCode.png");
            CodeUtils.creatRrCode(sb.toString(), 500, 500, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

