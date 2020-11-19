package com.xz.match.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.MatchSubject;
import com.xz.match.entity.SignRecordExample;
import com.xz.match.entity.SignRecord;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.excel.Tuple;

/**
 * @author chenwf
 * @date 2020/11/16
 */
public interface SignRecordService {


    long countByExample(SignRecordExample example);

    int deleteByExample(SignRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SignRecord record);

    int insertSelective(SignRecord record);

    List<SignRecord> selectByExample(SignRecordExample example);

    SignRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(SignRecord record, SignRecordExample example);

    int updateByExample(SignRecord record, SignRecordExample example);

    int updateByPrimaryKeySelective(SignRecord record);

    int updateByPrimaryKey(SignRecord record);

    List<Map<String, Object>> countSignRecordDispatchInfo(Map<String, Object> param);

    List<SignRecord> findBy(JSONObject param);

    void importMacthSignRecord(MatchSubject matchSubject, Tuple<List<JSONObject>, List<String>> result, Map<Tuple<String, String>, Integer> relation, JSONObject param);

    String autoOrderId();

    /**
     * 物资领取完，签字
     * @param recordId
     * @param picData
     */
    ResponseResult uploadSignPic(Long recordId, String picData);

    /**
     * 参赛人员列表
     * @param pageParam
     * @param param
     * @return
     */
    ResponseResult getRecordInfos(PageParam pageParam, JSONObject param);
}





