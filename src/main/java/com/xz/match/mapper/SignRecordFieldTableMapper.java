package com.xz.match.mapper;

import com.xz.match.entity.SignRecordFieldTable;
import com.xz.match.entity.SignRecordFieldTableExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
public interface SignRecordFieldTableMapper {
    long countByExample(SignRecordFieldTableExample example);

    int deleteByExample(SignRecordFieldTableExample example);

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
    int insert(SignRecordFieldTable record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SignRecordFieldTable record);

    List<SignRecordFieldTable> selectByExample(SignRecordFieldTableExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SignRecordFieldTable selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SignRecordFieldTable record, @Param("example") SignRecordFieldTableExample example);

    int updateByExample(@Param("record") SignRecordFieldTable record, @Param("example") SignRecordFieldTableExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SignRecordFieldTable record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SignRecordFieldTable record);

    List<SignRecordFieldTable> findBy(Map paramMap);
}