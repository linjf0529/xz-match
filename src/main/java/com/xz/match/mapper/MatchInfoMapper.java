package com.xz.match.mapper;

import com.xz.match.entity.MatchInfo;
import com.xz.match.entity.MatchInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenwf
 * @date 2020/11/19
 */
public interface MatchInfoMapper {
    long countByExample(MatchInfoExample example);

    int deleteByExample(MatchInfoExample example);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(MatchInfo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchInfo record);

    List<MatchInfo> selectByExample(MatchInfoExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    MatchInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchInfo record, @Param("example") MatchInfoExample example);

    int updateByExample(@Param("record") MatchInfo record, @Param("example") MatchInfoExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchInfo record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchInfo record);

    int updateBatch(List<MatchInfo> list);

    int batchInsert(@Param("list") List<MatchInfo> list);
}