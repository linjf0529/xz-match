package com.xz.match.mapper;

import com.xz.match.entity.ReserveRecord;
import com.xz.match.entity.ReserveRecordExample;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.vo.ReserveRecordVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenwf
 * @date 2020/11/19
 */
public interface ReserveRecordMapper {
    long countByExample(ReserveRecordExample example);

    int deleteByExample(ReserveRecordExample example);

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
    int insert(ReserveRecord record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ReserveRecord record);

    List<ReserveRecord> selectByExample(ReserveRecordExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ReserveRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReserveRecord record, @Param("example") ReserveRecordExample example);

    int updateByExample(@Param("record") ReserveRecord record, @Param("example") ReserveRecordExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ReserveRecord record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ReserveRecord record);

    List<ReserveRecordVO> findBy(Map<String,Object> map);
}