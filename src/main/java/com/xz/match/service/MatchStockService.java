package com.xz.match.service;

import com.xz.match.entity.MatchStockExample;
import java.util.List;
import com.xz.match.entity.MatchStock;
import com.xz.match.entity.vo.MatchStockVO;
import com.xz.match.utils.ResponseResult;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchStockService{


    long countByExample(MatchStockExample example);

    int deleteByExample(MatchStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchStock record);

    int insertSelective(MatchStock record);

    List<MatchStock> selectByExample(MatchStockExample example);

    MatchStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchStock record,MatchStockExample example);

    int updateByExample(MatchStock record,MatchStockExample example);

    int updateByPrimaryKeySelective(MatchStock record);

    int updateByPrimaryKey(MatchStock record);

    /**
     * 添加库存
     *
     * @param matchStockVO 库存VO
     * @return {@link ResponseResult}
     */
    ResponseResult addMatchStock(MatchStockVO matchStockVO);


    /**
     * 根据产品id查询物资库存
     *
     * @param productId 产品id
     * @return {@link ResponseResult}
     */
    ResponseResult findMatchStock(Long productId);
}
