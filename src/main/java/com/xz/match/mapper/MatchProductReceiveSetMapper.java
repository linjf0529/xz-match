package com.xz.match.mapper;

import com.xz.match.entity.MatchProductReceiveSet;
import com.xz.match.entity.MatchProductReceiveSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchProductReceiveSetMapper {
    long countByExample(MatchProductReceiveSetExample example);

    int deleteByExample(MatchProductReceiveSetExample example);

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
    int insert(MatchProductReceiveSet record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchProductReceiveSet record);

    List<MatchProductReceiveSet> selectByExample(MatchProductReceiveSetExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchProductReceiveSet selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchProductReceiveSet record, @Param("example") MatchProductReceiveSetExample example);

    int updateByExample(@Param("record") MatchProductReceiveSet record, @Param("example") MatchProductReceiveSetExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchProductReceiveSet record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchProductReceiveSet record);
}