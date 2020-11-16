package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.MatchProductSub;
import com.xz.match.entity.MatchProductSubExample;
    /**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchProductSubService{


    long countByExample(MatchProductSubExample example);

    int deleteByExample(MatchProductSubExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchProductSub record);

    int insertSelective(MatchProductSub record);

    List<MatchProductSub> selectByExample(MatchProductSubExample example);

    MatchProductSub selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchProductSub record,MatchProductSubExample example);

    int updateByExample(MatchProductSub record,MatchProductSubExample example);

    int updateByPrimaryKeySelective(MatchProductSub record);

    int updateByPrimaryKey(MatchProductSub record);

}
