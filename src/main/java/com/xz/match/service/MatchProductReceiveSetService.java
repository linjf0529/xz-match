package com.xz.match.service;

import com.xz.match.entity.MatchProductReceiveSetExample;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.MatchProductReceiveSet;
import com.xz.match.entity.vo.MatchProductReceiveSetVO;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */
public interface MatchProductReceiveSetService{


    long countByExample(MatchProductReceiveSetExample example);

    int deleteByExample(MatchProductReceiveSetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchProductReceiveSet record);

    int insertSelective(MatchProductReceiveSet record);

    List<MatchProductReceiveSet> selectByExample(MatchProductReceiveSetExample example);

    MatchProductReceiveSet selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchProductReceiveSet record, MatchProductReceiveSetExample example);

    int updateByExample(MatchProductReceiveSet record, MatchProductReceiveSetExample example);

    int updateByPrimaryKeySelective(MatchProductReceiveSet record);

    int updateByPrimaryKey(MatchProductReceiveSet record);

    /**
     * 查找所有个人项目
     *
     * @param pageParam 页面参数
     * @param param     参数
     * @return {@link ResponseResult}
     */
    ResponseResult findMatchProductReceiveSet(PageParam pageParam, Map<String, Object> param);


    /**
     * 查找赛事项目报名字段
     *
     * @param param 参数
     * @return {@link MatchProductReceiveSetVO}
     */
    MatchProductReceiveSetVO findMatchProductReceiveSetBySubjectId(Map<String, Object> param);


    /**
     * 修改物资领取配置
     *
     * @param matchProductReceiveSetVO 物资领取配置VO
     * @return {@link ResponseResult}
     */
    ResponseResult modifyMatchProductReceiveSet(MatchProductReceiveSetVO matchProductReceiveSetVO);

    /**
     * 根据报名记录id和科目id查询物资领取信息
     *
     * @param userId  用户id
     * @param subjectId 对象id
     * @return {@link ResponseResult}
     */
    ResponseResult findMatchProductReceiveSetByRecordIdAndSubjectId(Long userId, Long subjectId,String phone) ;

    void getBarCode(Long subjectId, Long userId, HttpServletResponse response);

    /**
     * 下载赛事科目二维码
     * @param subjectId
     * @param matchId
     * @param response
     */
    void downloadBarCode(Long subjectId, Long matchId, HttpServletResponse response);
}
