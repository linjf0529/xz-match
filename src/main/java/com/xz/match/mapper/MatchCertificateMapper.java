package com.xz.match.mapper;

import com.xz.match.entity.MatchCertificate;
import com.xz.match.entity.MatchCertificateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchCertificateMapper {
    long countByExample(MatchCertificateExample example);

    int deleteByExample(MatchCertificateExample example);

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
    int insert(MatchCertificate record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MatchCertificate record);

    List<MatchCertificate> selectByExample(MatchCertificateExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MatchCertificate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MatchCertificate record, @Param("example") MatchCertificateExample example);

    int updateByExample(@Param("record") MatchCertificate record, @Param("example") MatchCertificateExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MatchCertificate record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MatchCertificate record);
}