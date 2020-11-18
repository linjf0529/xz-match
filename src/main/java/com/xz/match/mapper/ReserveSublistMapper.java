package com.xz.match.mapper;

import com.xz.match.entity.ReserveSublist;
import com.xz.match.entity.ReserveSublistExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
public interface ReserveSublistMapper {
    long countByExample(ReserveSublistExample example);

    int deleteByExample(ReserveSublistExample example);

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
    int insert(ReserveSublist record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ReserveSublist record);

    List<ReserveSublist> selectByExample(ReserveSublistExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ReserveSublist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReserveSublist record, @Param("example") ReserveSublistExample example);

    int updateByExample(@Param("record") ReserveSublist record, @Param("example") ReserveSublistExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ReserveSublist record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ReserveSublist record);

    /**
     *
     * @param map
     * @return
     */
    List<ReserveSublist> findBy(Map<String,Object> map);
}