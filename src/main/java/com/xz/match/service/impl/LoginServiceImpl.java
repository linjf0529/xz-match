package com.xz.match.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.UserInfo;
import com.xz.match.entity.vo.LoginVo;
import com.xz.match.service.LoginService;
import com.xz.match.service.UserInfoService;
import com.xz.match.utils.RedisClient;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.StringUtils;
import com.xz.match.utils.constants.RedisKey;
import com.xz.match.utils.exception.CommonException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author chenwf
 * @date 2020/11/17
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Resource
    private RedisClient redisClient;
    @Resource
    private UserInfoService userInfoService;

    @Override
    public ResponseResult login(LoginVo loginVo){
        Integer type = loginVo.getType();
        String verifiyCode = loginVo.getVerifiyCode();
        String certificateNo = loginVo.getCertificateNo();
        String phone = loginVo.getPhone();
        String passWord = loginVo.getPassWord();
        if(StringUtils.isEmpty(phone)){
            throw new CommonException("手机号码不能为空");
        }
        UserInfo userInfo = userInfoService.findByMobile(phone,type,certificateNo);
        if(userInfo == null){
            throw new CommonException("改手机号码未被注册");
        }
        if(type == 1){
            if(StringUtils.isEmpty(verifiyCode)){
                throw new CommonException("验证码不能为空");
            }
            if(!redisClient.hasKey(RedisKey.VERIDIY_CODE_KEY + verifiyCode)){
                throw new CommonException("请先获取短信验证码");
            }
            String tk = redisClient.get(RedisKey.VERIDIY_CODE_KEY + verifiyCode);
            if(!verifiyCode.equals(tk)){
                throw new CommonException("验证码输入错误");
            }
        }else if(type == 2){
            if(StringUtils.isEmpty(certificateNo)){
                throw new CommonException("身份证号码不能为空");
            }
            if(StringUtils.isEmpty(verifiyCode)){
                throw new CommonException("验证码不能为空");
            }
            if(!redisClient.hasKey(RedisKey.VERIDIY_CODE_KEY + verifiyCode)){
                throw new CommonException("请先获取短信验证码");
            }
            String tk = redisClient.get(RedisKey.VERIDIY_CODE_KEY + verifiyCode);
            if(!verifiyCode.equals(tk)){
                throw new CommonException("验证码输入错误");
            }
        }else if(type == 3){
            if(StringUtils.isEmpty(passWord)){
                throw new CommonException("请输入密码");
            }
            if(!passWord.equals(userInfo.getPassWord())){
                throw new CommonException("密码错误，请重新输入");
            }
        }else {
            throw new CommonException("登录类型出错");
        }
        String uuid = UUID.randomUUID().toString();
        redisClient.set(uuid, JSONObject.toJSONString(userInfo),180 * 60 * 60 * 60 * 1000);
        JSONObject userJson = new JSONObject();
        userJson.put("token",uuid);
        userJson.put("userId",userInfo.getId());
        userJson.put("phone",userInfo.getPhone());
        userJson.put("certificateNo",userInfo.getCertificateNo());
        return ResponseResult.ok().setData(userJson.toJSONString());
    }
}
