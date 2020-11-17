package com.xz.match.mapper;

import com.xz.match.entity.MatchImage;
import com.xz.match.entity.MatchImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
public interface MatchImageMapper {
    long countByExample(MatchImageExample example);

    int deleteByExample(MatchImageExample example);

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
    int insert(MatchImage record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchImage record);

    List<MatchImage> selectByExample(MatchImageExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchImage record, @Param("example") MatchImageExample example);

    int updateByExample(@Param("record") MatchImage record, @Param("example") MatchImageExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchImage record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchImage record);
}