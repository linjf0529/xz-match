package com.xz.match.service;

import java.util.List;
import java.util.Map;

import com.xz.match.entity.MatchCertificateSublistExample;
import com.xz.match.entity.MatchCertificateSublist;
    /**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
public interface MatchCertificateSublistService{


    long countByExample(MatchCertificateSublistExample example);

    int deleteByExample(MatchCertificateSublistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchCertificateSublist record);

    int insertSelective(MatchCertificateSublist record);

    List<MatchCertificateSublist> selectByExample(MatchCertificateSublistExample example);

    MatchCertificateSublist selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchCertificateSublist record,MatchCertificateSublistExample example);

    int updateByExample(MatchCertificateSublist record,MatchCertificateSublistExample example);

    int updateByPrimaryKeySelective(MatchCertificateSublist record);

    int updateByPrimaryKey(MatchCertificateSublist record);

    List<MatchCertificateSublist> findBy(Map<String,Object> map);

    void deleteSubject(Map<String,Object> map);

    List<MatchCertificateSublist> getCertificateSublist(Map<String,Object> map);
}
