package com.xz.match.mapper;

import com.xz.match.entity.SubjectSignField;
import com.xz.match.entity.SubjectSignFieldExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
public interface SubjectSignFieldMapper {
    long countByExample(SubjectSignFieldExample example);

    int deleteByExample(SubjectSignFieldExample example);

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
    int insert(SubjectSignField record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SubjectSignField record);

    List<SubjectSignField> selectByExample(SubjectSignFieldExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SubjectSignField selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubjectSignField record, @Param("example") SubjectSignFieldExample example);

    int updateByExample(@Param("record") SubjectSignField record, @Param("example") SubjectSignFieldExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SubjectSignField record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SubjectSignField record);

    List<SubjectSignField> findBy(Map<String, Object> param);
}