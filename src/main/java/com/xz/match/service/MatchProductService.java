package com.xz.match.service;

import java.util.List;
import java.util.Map;

import com.xz.match.entity.MatchProduct;
import com.xz.match.entity.MatchProductExample;
import com.xz.match.entity.vo.MatchProductVO;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchProductService{


    long countByExample(MatchProductExample example);

    int deleteByExample(MatchProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchProduct record);

    int insertSelective(MatchProduct record);

    List<MatchProduct> selectByExample(MatchProductExample example);

    MatchProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchProduct record,MatchProductExample example);

    int updateByExample(MatchProduct record,MatchProductExample example);

    int updateByPrimaryKeySelective(MatchProduct record);

    int updateByPrimaryKey(MatchProduct record);

    /**
     * 添加物资
     *
     * @param matchProductVO 物资VO
     * @return {@link ResponseResult}
     */
    ResponseResult addMatchProduct(MatchProductVO matchProductVO);

    /**
     * 查找物资
     *
     * @param params    参数个数
     * @param pageParam 页面参数
     * @return {@link ResponseResult}
     */
    ResponseResult findMatchProducts(PageParam pageParam, Map<String, Object> params);

    /**
     * 根据id查询物资id
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    ResponseResult findMatchProductById(Long id);

    /**
     * 修改物资
     *
     * @param matchProductVO 物资VO
     * @return {@link ResponseResult}
     */
    ResponseResult modifyMatchProduct(MatchProductVO matchProductVO);

    /**
     * 删除物资
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    ResponseResult removeMatchProduct(Long id);

    List<MatchProduct> findBy(Map param);
}
