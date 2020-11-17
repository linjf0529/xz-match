package com.xz.match.service;

import java.util.List;
import com.xz.match.entity.MatchImage;
import com.xz.match.entity.MatchImageExample;
    /**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
public interface MatchImageService{


    long countByExample(MatchImageExample example);

    int deleteByExample(MatchImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MatchImage record);

    int insertSelective(MatchImage record);

    List<MatchImage> selectByExample(MatchImageExample example);

    MatchImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(MatchImage record,MatchImageExample example);

    int updateByExample(MatchImage record,MatchImageExample example);

    int updateByPrimaryKeySelective(MatchImage record);

    int updateByPrimaryKey(MatchImage record);

}
