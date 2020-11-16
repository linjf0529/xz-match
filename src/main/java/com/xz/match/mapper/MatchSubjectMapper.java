package com.xz.match.mapper;

import com.xz.match.entity.MatchSubject;
import com.xz.match.entity.MatchSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchSubjectMapper {
    long countByExample(MatchSubjectExample example);

    int deleteByExample(MatchSubjectExample example);

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
    int insert(MatchSubject record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchSubject record);

    List<MatchSubject> selectByExample(MatchSubjectExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchSubject record, @Param("example") MatchSubjectExample example);

    int updateByExample(@Param("record") MatchSubject record, @Param("example") MatchSubjectExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchSubject record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchSubject record);
}