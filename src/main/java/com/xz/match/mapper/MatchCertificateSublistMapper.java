package com.xz.match.mapper;

import com.xz.match.entity.MatchCertificateSublist;
import com.xz.match.entity.MatchCertificateSublistExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchCertificateSublistMapper {
    long countByExample(MatchCertificateSublistExample example);

    int deleteByExample(MatchCertificateSublistExample example);

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
    int insert(MatchCertificateSublist record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchCertificateSublist record);

    List<MatchCertificateSublist> selectByExample(MatchCertificateSublistExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchCertificateSublist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchCertificateSublist record, @Param("example") MatchCertificateSublistExample example);

    int updateByExample(@Param("record") MatchCertificateSublist record, @Param("example") MatchCertificateSublistExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchCertificateSublist record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchCertificateSublist record);

    /**
     *
     * @param map
     * @return
     */
    List<MatchCertificateSublist> findBy(Map<String,Object> map);

    void deleteSubject(Map<String,Object> map);

    List<MatchCertificateSublist> getCertificateSublist(Map<String,Object> map);
}