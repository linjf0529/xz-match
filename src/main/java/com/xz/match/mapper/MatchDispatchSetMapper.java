package com.xz.match.mapper;

import com.xz.match.entity.MatchDispatchSet;
import com.xz.match.entity.MatchDispatchSetExample;
import java.util.List;
import java.util.Map;

import com.xz.match.entity.vo.MatchDispatchPermissionVO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchDispatchSetMapper {
    long countByExample(MatchDispatchSetExample example);

    int deleteByExample(MatchDispatchSetExample example);

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
    int insert(MatchDispatchSet record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchDispatchSet record);

    List<MatchDispatchSet> selectByExample(MatchDispatchSetExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchDispatchSet selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchDispatchSet record, @Param("example") MatchDispatchSetExample example);

    int updateByExample(@Param("record") MatchDispatchSet record, @Param("example") MatchDispatchSetExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchDispatchSet record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchDispatchSet record);

    List<MatchDispatchSet> findBy(Map param);

    /**
     * 配置发放人员的权限
     *
     * @return {@link List<MatchDispatchPermissionVO>}
     */
    List<MatchDispatchPermissionVO> selectMatchDispatchPermission();
}