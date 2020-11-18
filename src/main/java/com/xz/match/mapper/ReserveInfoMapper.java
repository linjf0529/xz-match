package com.xz.match.mapper;

import com.xz.match.entity.ReserveInfo;
import com.xz.match.entity.ReserveInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
public interface ReserveInfoMapper {
    long countByExample(ReserveInfoExample example);

    int deleteByExample(ReserveInfoExample example);

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
    int insert(ReserveInfo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ReserveInfo record);

    List<ReserveInfo> selectByExample(ReserveInfoExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ReserveInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReserveInfo record, @Param("example") ReserveInfoExample example);

    int updateByExample(@Param("record") ReserveInfo record, @Param("example") ReserveInfoExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ReserveInfo record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ReserveInfo record);
}