package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.MatchProduct;
import com.xz.match.entity.MatchProductExample;
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

}
