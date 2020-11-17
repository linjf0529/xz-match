package com.xz.match.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.*;
import com.xz.match.entity.vo.MatchProductReceiveSetVO;
import com.xz.match.mapper.MatchProductReceiveSetMapper;
import com.xz.match.service.MatchProductReceiveSetService;
import com.xz.match.service.MatchProductService;
import com.xz.match.service.SignRecordFieldTableService;
import com.xz.match.service.SubjectSignFieldService;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchProductReceiveSetServiceImpl implements MatchProductReceiveSetService{

    @Resource
    private MatchProductReceiveSetMapper matchProductReceiveSetMapper;

    @Resource
    private SignRecordFieldTableService signRecordFieldTableService;

    @Resource
    private SubjectSignFieldService subjectSignFieldService;

    @Resource
    private MatchProductService matchProductService;

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

    /**
     * 获取微信小程序码
     *
     * @return {@link Byte[]}
     */


    @Override
    public byte[] findWxCode(String recordId)  {



//        // 本地调试用
//        String appId = "wxd058d9de2f6e9e79";
//        String secret = "0d03ae14c53339fdd069f99afd08e233";
//
//        String  wxKey  = "wx_access_token_" + appId + secret;
//        Object accessToken = reqCache.get(wxKey);
//
//        if(StringUtils.isEmpty(accessToken)){
//            String wxResult = getAccessToken(appId,secret);
//            JSONObject js = JSONObject.parseObject(wxResult);
//            accessToken = js.getString("access_token");
//            if(!StringUtils.isEmpty(accessToken)){
//                reqCache.put(wxKey, accessToken);
//            }
//            ValidateUtils.notNull(accessToken,"access_token值为空");
//        }
//
//        String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+accessToken;
//        Map<String,String> dataMap = new HashMap<>();
//        dataMap.put("page","pages/step");
//        dataMap.put("scene",recordId);
//        byte[] bytes = HttpRequest.post(url).body(JSONObject.toJSONString(dataMap)).execute().bodyBytes();
        return null;
    }

    private String getAccessToken(String appid, String secret) {
//        ValidateUtils.notNull(appid,"appId为空");
//        ValidateUtils.notNull(secret,"appSecret为空");
//        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=".concat(appid).concat("&secret=").concat(secret);
        return null;
    }
}
