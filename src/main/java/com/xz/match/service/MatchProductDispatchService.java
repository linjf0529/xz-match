package com.xz.match.service;

import java.util.List;
import java.util.Map;

import com.xz.match.entity.MatchProductDispatch;
import com.xz.match.entity.MatchProductDispatchExample;
import com.xz.match.entity.vo.MatchProductDispatchVO;
import com.xz.match.utils.ResponseResult;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchProductDispatchService{


    long countByExample(MatchProductDispatchExample example);

    int deleteByExample(MatchProductDispatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchProductDispatch record);

    int insertSelective(MatchProductDispatch record);

    List<MatchProductDispatch> selectByExample(MatchProductDispatchExample example);

    MatchProductDispatch selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchProductDispatch record,MatchProductDispatchExample example);

    int updateByExample(MatchProductDispatch record,MatchProductDispatchExample example);

    int updateByPrimaryKeySelective(MatchProductDispatch record);

    int updateByPrimaryKey(MatchProductDispatch record);

    /**
     * 查找发放信息
     *
     * @param recordId  记录id
     * @param subjectId 对象id
     * @return {@link ResponseResult}
     */
    ResponseResult findMatchProductDispatch(Long recordId, Long subjectId) ;

    /**
     * 添加发放信息
     *
     * @param matchProductDispatchVO 物资发放VO
     * @param currentUserName
     * @return {@link ResponseResult}
     * * @ 业务异常
     */
    ResponseResult addMatchProductDispatch(MatchProductDispatchVO matchProductDispatchVO, String currentUserName) ;


    /**
     * 统计参赛人员的物资发放状态
     *
     * @param param 参数
     * @return {@link ResponseResult}
     */
    ResponseResult findSignRecordDispatchInfo(Map<String, Object> param) ;
}
