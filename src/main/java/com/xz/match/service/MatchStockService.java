package com.xz.match.service;

import com.xz.match.entity.MatchStockExample;
import java.util.List;
import com.xz.match.entity.MatchStock;
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

}
