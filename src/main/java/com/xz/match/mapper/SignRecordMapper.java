package com.xz.match.mapper;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.SignRecord;
import com.xz.match.entity.SignRecordExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface SignRecordMapper {
    long countByExample(SignRecordExample example);

    int deleteByExample(SignRecordExample example);

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
    int insert(SignRecord record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SignRecord record);

    List<SignRecord> selectByExample(SignRecordExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SignRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SignRecord record, @Param("example") SignRecordExample example);

    int updateByExample(@Param("record") SignRecord record, @Param("example") SignRecordExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SignRecord record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SignRecord record);

    List<Map<String,Object>> countSignRecordDispatchInfo(Map<String, Object> param);

    List<SignRecord> findBy(JSONObject param);
}