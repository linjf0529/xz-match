package com.xz.match.service.impl;

import com.xz.match.utils.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.entity.UserInfoExample;
import java.util.List;
import com.xz.match.mapper.UserInfoMapper;
import com.xz.match.entity.UserInfo;
import com.xz.match.service.UserInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenwf
 * @date 2020/11/16
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public long countByExample(UserInfoExample example) {
        return userInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserInfoExample example) {
        return userInfoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public List<UserInfo> selectByExample(UserInfoExample example) {
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserInfo record, UserInfoExample example) {
        return userInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UserInfo record, UserInfoExample example) {
        return userInfoMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public UserInfo findByMobile(String phone, Integer type, String certificateNo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criterion = userInfoExample.createCriteria();
        criterion.andPhoneEqualTo(phone).andTypeEqualTo(type);
        if(type == 2 && StringUtils.isNotEmpty(certificateNo)){
            criterion.andCertificateNoEqualTo(certificateNo);
        }
        List<UserInfo> userInfos = this.selectByExample(userInfoExample);
        if (!userInfos.isEmpty()) {
            return userInfos.get(0);
        }
        return null;
    }

    @Override
    public UserInfo saveUser(String phone, String certificateNo, String name, int type) {
        UserInfo userInfo = findByMobile(phone,type,"");
        if(userInfo == null){
            userInfo = new UserInfo();
            userInfo.setCertificateNo(certificateNo);
            userInfo.setPhone(phone);
            userInfo.setType(type);
            userInfo.setUserName(name);
            if(type == 1){
                userInfo.setPassWord(phone);
            }
            this.insertSelective(userInfo);
        }
        return userInfo;
    }
}

