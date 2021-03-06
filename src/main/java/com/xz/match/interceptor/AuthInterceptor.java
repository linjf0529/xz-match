package com.xz.match.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.UserInfo;
import com.xz.match.utils.RedisClient;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.StringUtils;
import com.xz.match.utils.aop.AllowAnonymous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chenwf
 * @date 2020/11/17
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisClient redisClient;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("==================");
        return this.interceptor(request, response, handler);
    }

    protected boolean interceptor(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String method = request.getMethod();
        if ("OPTIONS".equalsIgnoreCase(method)) {
            response.setStatus(200);
            return false;
        } else {
            boolean success = false;
            AllowAnonymous allowAnonymous = (AllowAnonymous)((HandlerMethod)handler).getMethod().getAnnotation(AllowAnonymous.class);
            if (allowAnonymous != null) {
                return true;
            }
            String authorization = request.getHeader("Authorization");
            if(StringUtils.isEmpty(authorization)){
                abortWith(response,201);
                return false;
            }
            String userInfo = redisClient.get(authorization);
            if (StringUtils.isEmpty(userInfo)) {
                abortWith(response,201);
                return false;
            }else {
                JSONObject json = JSONObject.parseObject(userInfo);
                request.setAttribute("userId",json.getLong("id"));
                request.setAttribute("phone",json.getString("phone"));
                request.setAttribute("certificateNo",json.getString("certificateNo"));
                request.setAttribute("userName",json.getString("userName"));
                return true;
            }
        }
    }

    private void abortWith(HttpServletResponse response, int code) {
        ResponseResult responseResult = ResponseResult.getResponse(code);
        responseResult.setMessage("您未登录");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;

        try {
            out = response.getWriter();
            out.append(JSON.toJSONString(responseResult));
            out.flush();
        } catch (IOException var7) {

        }finally {
            if(out != null){
                out.close();
            }
        }

    }
}
