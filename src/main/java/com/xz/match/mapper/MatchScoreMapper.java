package com.xz.match.mapper;

import com.xz.match.entity.MatchScore;
import com.xz.match.entity.MatchScoreExample;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.SignRecord;
import com.xz.match.entity.vo.SignRecordScoreVO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchScoreMapper {
    long countByExample(MatchScoreExample example);

    int deleteByExample(MatchScoreExample example);

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
    int insert(MatchScore record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchScore record);

    List<MatchScore> selectByExample(MatchScoreExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchScore record, @Param("example") MatchScoreExample example);

    int updateByExample(@Param("record") MatchScore record, @Param("example") MatchScoreExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchScore record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchScore record);

    /**
     * 根据报名记录和科目id查询成绩
     * @param map
     * @return
     */
    List<MatchScore> getMatchScoreList(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    List<SignRecordScoreVO> findSignRecordScore(Map<String,Object> map);
}