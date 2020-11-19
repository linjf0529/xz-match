package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.utils.NumberUtils;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.StringUtils;
import com.xz.match.utils.exception.CommonException;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chenwf
 * @date 2020/11/17
 */
public class BaseController {

    public JSONObject getJSONObject(HttpServletRequest request) {
        Map<String, String[]> multiParam = request.getParameterMap();
        JSONObject json = new JSONObject();
        Set<String> keySet = multiParam.keySet();
        Iterator var5 = keySet.iterator();

        while(var5.hasNext()) {
            String key = (String)var5.next();
            String[] values = (String[])multiParam.get(key);
            if (values != null && values.length > 0) {
                if (values.length == 1) {
                    if ("pageNo".equals(key)) {
                        json.put(key, NumberUtils.toInteger(values[0]));
                    } else if ("pageSize".equals(key)) {
                        json.put(key, NumberUtils.toInteger(values[0]));
                    } else {
                        json.put(key, StringUtils.msNull(values[0]));
                    }
                } else {
                    json.put(key, values);
                }
            }
        }

        return json;
    }

    public PageParam getPageParam(HttpServletRequest request) {
        PageParam pageParam = null;
        int pageNo = NumberUtils.toInteger(request.getParameter("pageNo"));
        int pageSize = NumberUtils.toInteger(request.getParameter("pageSize"), 10);
        if (pageSize > 0) {
            pageParam = new PageParam(pageNo, pageSize);
        }

        return pageParam;
    }

    public Map<String, Object> getParameterMap(HttpServletRequest request) {
        Map<String, String[]> multiParam = request.getParameterMap();
        Map<String, Object> params = new LinkedHashMap();
        Set<String> keySet = multiParam.keySet();
        Iterator var5 = keySet.iterator();

        while(var5.hasNext()) {
            String key = (String)var5.next();
            String[] values = (String[])multiParam.get(key);
            if (values != null && values.length > 0) {
                if (values.length == 1) {
                    if ("pageNo".equals(key)) {
                        params.put(key, NumberUtils.toInteger(values[0]));
                    } else if ("pageSize".equals(key)) {
                        params.put(key, NumberUtils.toInteger(values[0]));
                    } else {
                        params.put(key, StringUtils.msNull(values[0]));
                    }
                } else {
                    params.put(key, values);
                }
            }
        }

        return params;
    }


    public Long getCurrentUserId(HttpServletRequest request) {
        Object userId = request.getAttribute("userId");
        if(userId == null){
            throw new CommonException("请登录");
        }
        return Long.parseLong(userId.toString());
    }

    public String getCurrentPhone(HttpServletRequest request) {
        Object phone = (String)request.getAttribute("phone");
        if(phone == null){
            throw new CommonException("请登录");
        }
        return phone.toString();
    }

    public String getCurrentUserName(HttpServletRequest request) {
        Object userName = (String)request.getAttribute("userName");
        if(userName == null){
            throw new CommonException("请登录");
        }
        return userName.toString();
    }
}
