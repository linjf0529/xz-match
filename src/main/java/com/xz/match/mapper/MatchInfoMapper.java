package com.xz.match.mapper;

import com.xz.match.entity.MatchInfo;
import com.xz.match.entity.MatchInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenwf
 * @date 2020/11/16
 */
public interface MatchInfoMapper {
    long countByExample(MatchInfoExample example);

    int deleteByExample(MatchInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(MatchInfo record);

    int insertSelective(MatchInfo record);

    List<MatchInfo> selectByExample(MatchInfoExample example);

    MatchInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MatchInfo record, @Param("example") MatchInfoExample example);

    int updateByExample(@Param("record") MatchInfo record, @Param("example") MatchInfoExample example);

    int updateByPrimaryKeySelective(MatchInfo record);

    int updateByPrimaryKey(MatchInfo record);

    int updateBatch(List<MatchInfo> list);

    int batchInsert(@Param("list") List<MatchInfo> list);
}