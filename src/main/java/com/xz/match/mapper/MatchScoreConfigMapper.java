package com.xz.match.mapper;

import com.xz.match.entity.MatchScoreConfig;
import com.xz.match.entity.MatchScoreConfigExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchScoreConfigMapper {
    long countByExample(MatchScoreConfigExample example);

    int deleteByExample(MatchScoreConfigExample example);

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
    int insert(MatchScoreConfig record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchScoreConfig record);

    List<MatchScoreConfig> selectByExample(MatchScoreConfigExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchScoreConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchScoreConfig record, @Param("example") MatchScoreConfigExample example);

    int updateByExample(@Param("record") MatchScoreConfig record, @Param("example") MatchScoreConfigExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchScoreConfig record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchScoreConfig record);

    /**
     *
     * @param map
     * @return
     */
    List<MatchScoreConfig> findBy(Map<String,Object> map);

    Integer getMaxSort(@Param("subjectId")Long subjectId);
}