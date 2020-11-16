package com.xz.match.mapper;

import com.xz.match.entity.MatchStock;
import com.xz.match.entity.MatchStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchStockMapper {
    long countByExample(MatchStockExample example);

    int deleteByExample(MatchStockExample example);

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
    int insert(MatchStock record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchStock record);

    List<MatchStock> selectByExample(MatchStockExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchStock record, @Param("example") MatchStockExample example);

    int updateByExample(@Param("record") MatchStock record, @Param("example") MatchStockExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchStock record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchStock record);
}