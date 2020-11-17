package com.xz.match.service;

import com.xz.match.entity.vo.LoginVo;
import com.xz.match.utils.ResponseResult;

/**
 * @author chenwf
 * @date 2020/11/17
 */
public interface LoginService {
    ResponseResult login(LoginVo loginVo);
}
