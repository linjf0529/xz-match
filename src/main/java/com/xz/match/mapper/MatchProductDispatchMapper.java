package com.xz.match.mapper;

import com.xz.match.entity.MatchProductDispatch;
import com.xz.match.entity.MatchProductDispatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchProductDispatchMapper {
    long countByExample(MatchProductDispatchExample example);

    int deleteByExample(MatchProductDispatchExample example);

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
    int insert(MatchProductDispatch record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchProductDispatch record);

    List<MatchProductDispatch> selectByExample(MatchProductDispatchExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchProductDispatch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchProductDispatch record, @Param("example") MatchProductDispatchExample example);

    int updateByExample(@Param("record") MatchProductDispatch record, @Param("example") MatchProductDispatchExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchProductDispatch record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchProductDispatch record);
}