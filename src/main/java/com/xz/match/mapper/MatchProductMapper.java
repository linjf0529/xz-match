package com.xz.match.mapper;

import com.xz.match.entity.MatchProduct;
import com.xz.match.entity.MatchProductExample;
import java.util.List;import java.util.Map;
import com.xz.match.entity.vo.MatchStockVO;import org.apache.ibatis.annotations.Param;

/**
 * @author chenwf
 * @date 2020/11/19
 */
public interface MatchProductMapper {
    long countByExample(MatchProductExample example);

    int deleteByExample(MatchProductExample example);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(MatchProduct record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchProduct record);

    List<MatchProduct> selectByExample(MatchProductExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    MatchProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchProduct record, @Param("example") MatchProductExample example);

    int updateByExample(@Param("record") MatchProduct record, @Param("example") MatchProductExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchProduct record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchProduct record);

    List<MatchProduct> findBy(Map<String, Object> params);

    void updateToAddMatchStockByProductId(MatchStockVO matchStockVO);

    int updateToMinusMatchStockByProductId(MatchStockVO matchStockVO);
}