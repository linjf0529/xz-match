package com.xz.match.service;

import com.xz.match.entity.UserInfoExample;
import java.util.List;
import com.xz.match.entity.UserInfo;

/**
 * @author chenwf
 * @date 2020/11/16
 */
public interface UserInfoService {


    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserInfo record, UserInfoExample example);

    int updateByExample(UserInfo record, UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo findByMobile(String phone, Integer type, String certificateNo);

    UserInfo saveUser(String phone, String certificateNo, String name, int type);
}

