package com.xz.match.service;

import com.xz.match.entity.MatchCertificateExample;
import java.util.List;
import com.xz.match.entity.MatchCertificate;
import com.xz.match.utils.ResponseResult;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchCertificateService{


    long countByExample(MatchCertificateExample example);

    int deleteByExample(MatchCertificateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchCertificate record);

    int insertSelective(MatchCertificate record);

    List<MatchCertificate> selectByExample(MatchCertificateExample example);

    MatchCertificate selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchCertificate record,MatchCertificateExample example);

    int updateByExample(MatchCertificate record,MatchCertificateExample example);

    int updateByPrimaryKeySelective(MatchCertificate record);

    int updateByPrimaryKey(MatchCertificate record);

    MatchCertificate getCertificateBySubjectId(Long subjectId);

    ResponseResult uploadImage(final byte[] imageContent);
}
