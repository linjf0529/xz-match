package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.MatchProductSub;
import com.xz.match.entity.MatchProductSubExample;
import com.xz.match.entity.vo.MatchProductSubVO;
import com.xz.match.utils.ResponseResult;

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

        /**
         * 根据ProductId查询物资子项
         *
         * @param id id
         * @return {@link List<MatchProductSub>}
         */
        List<MatchProductSub> findMatchProductSubByProductId(Long id);

        /**
         * 根据id查询物资子项
         *
         * @param id id
         * @return {@link MatchProductSub}
         */
        ResponseResult findMatchProductSubById(Long id);
        /**
         * 修改物资子项
         *
         * @param matchProductSubVO 物资子项VO
         * @return {@link ResponseResult}
         */
        ResponseResult modifyMatchProductSub(MatchProductSubVO matchProductSubVO);

        /**
         * 删除物资子项
         *
         * @param id id
         * @return {@link ResponseResult}
         */
        ResponseResult removeMatchProductSub(Long id);

}
