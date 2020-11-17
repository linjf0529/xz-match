package com.xz.match.mapper;

import com.xz.match.entity.MatchProductSub;
import com.xz.match.entity.MatchProductSubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchProductSubMapper {
    long countByExample(MatchProductSubExample example);

    int deleteByExample(MatchProductSubExample example);

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(MatchProductSub record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchProductSub record);

    List<MatchProductSub> selectByExample(MatchProductSubExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchProductSub selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchProductSub record, @Param("example") MatchProductSubExample example);

    int updateByExample(@Param("record") MatchProductSub record, @Param("example") MatchProductSubExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchProductSub record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchProductSub record);

    List<MatchProductSub> selectMatchProductSubByProductId(Long productId);

    void updateToAddMatchStockByProductSubId(MatchProductSub matchProductSub);

    int updateToMinusMatchStockByProductSubId(MatchProductSub matchProductSub);
}