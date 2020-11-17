package com.xz.match.service;

import java.util.List;
import java.util.Map;

import com.xz.match.entity.SubjectSignField;
import com.xz.match.entity.SubjectSignFieldExample;
    /**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
public interface SubjectSignFieldService{


    long countByExample(SubjectSignFieldExample example);

    int deleteByExample(SubjectSignFieldExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubjectSignField record);

    int insertSelective(SubjectSignField record);

    List<SubjectSignField> selectByExample(SubjectSignFieldExample example);

    SubjectSignField selectByPrimaryKey(Long id);

    int updateByExampleSelective(SubjectSignField record,SubjectSignFieldExample example);

    int updateByExample(SubjectSignField record,SubjectSignFieldExample example);

    int updateByPrimaryKeySelective(SubjectSignField record);

    int updateByPrimaryKey(SubjectSignField record);

    List<SubjectSignField> findBy(Map<String, Object> param);
}
