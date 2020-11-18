package com.xz.match.service;

import java.util.List;
import java.util.Map;

import com.xz.match.entity.MatchDispatchSet;
import com.xz.match.entity.MatchDispatchSetExample;
import com.xz.match.entity.vo.MatchDispatchSetVO;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchDispatchSetService{


    long countByExample(MatchDispatchSetExample example);

    int deleteByExample(MatchDispatchSetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchDispatchSet record);

    int insertSelective(MatchDispatchSet record);

    List<MatchDispatchSet> selectByExample(MatchDispatchSetExample example);

    MatchDispatchSet selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchDispatchSet record,MatchDispatchSetExample example);

    int updateByExample(MatchDispatchSet record,MatchDispatchSetExample example);

    int updateByPrimaryKeySelective(MatchDispatchSet record);

    int updateByPrimaryKey(MatchDispatchSet record);

    /**
     * 通过电话查询发放人员配置
     *
     * @param param     参数
     * @param subjectId 对象id
     * @return {@link ResponseResult}
     */
    ResponseResult findMatchDispatchSetByPhone(String subjectId,Map<String, Object> param);

    /**
     * 找到发放人员配置
     *
     * @param params    参数个数
     * @return {@link ResponseResult}
     */
    ResponseResult findMatchDispatchSet(PageParam pageParam, Map<String, Object> params);
    /**
     * 添加发放人员配置
     *
     * @param matchDispatchSetVO 发放人员配置VO
     * @return {@link ResponseResult}
     */
    ResponseResult addMatchDispatchSet(MatchDispatchSetVO matchDispatchSetVO);

    /**
     * 删除发放人员配置
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    ResponseResult removeMatchDispatchSet(Long id);

    /**
     * 修改发放人员配置
     *
     * @param matchDispatchSetVO
     * @return {@link ResponseResult}
     */
    ResponseResult modifyMatchDispatchSet(MatchDispatchSetVO matchDispatchSetVO);

    /**
     * 根据id查找发放人员配置
     *
     * @param params 参数个数
     * @return {@link ResponseResult}
     */
    ResponseResult findMatchDispatchSetById(Map<String, Object> params);

}
