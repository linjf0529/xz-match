package com.xz.match.controller;

import com.xz.match.entity.vo.LoginVo;
import com.xz.match.entity.vo.MatchDispatchSetVO;
import com.xz.match.service.LoginService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.aop.AllowAnonymous;
import com.xz.match.utils.exception.CommonException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chenwf
 * @date 2020/11/17
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping
    @AllowAnonymous
    public ResponseResult login(@RequestBody LoginVo loginVo, HttpServletRequest request){
        if(loginVo == null){
            throw new CommonException("请求参数出错");
        }
        return loginService.login(loginVo);
    }
}
