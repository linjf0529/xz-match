package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.vo.MatchDispatchSetVO;
import com.xz.match.service.MatchDispatchSetService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.exception.CommonException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 发放人员配置表facade
 *
 * @author chenwf
 * @create 2020-11-17
 */
@RestController
@RequestMapping("/matchs/config")
public class MatchDispatchSetController extends BaseController{
    @Resource
    private MatchDispatchSetService matchDispatchSetService;

    /**
     * 创建发放人员配置
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @PostMapping
    public ResponseResult createMatchDispatchSet(@RequestBody MatchDispatchSetVO matchDispatchSetVO, HttpServletRequest request){
        if(matchDispatchSetVO == null){
            throw new CommonException("请求参数出错");
        }
        return matchDispatchSetService.addMatchDispatchSet(matchDispatchSetVO);
    }


    /**
     * 删除发放人员配置
     *
     * @param id      id
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult deleteMatchDispatchSet(@PathVariable("id") Long id, HttpServletRequest request){
        return matchDispatchSetService.removeMatchDispatchSet(id);
    }

    /**
     * 编辑发放人员配置
     *
     * @param id      id
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @PutMapping
    public ResponseResult editMatchDispatchSet(@RequestParam String id , HttpServletRequest request){
        return null;
    }

    /**
     * 查询发放人员配置
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @GetMapping
    public ResponseResult queryMatchDispatchSet(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        param.put("disabled",0);
        return matchDispatchSetService.findMatchDispatchSet(getPageParam(request),param);
    }

    /**
     * 通过电话查询发放人员
     *
     * @param request 请求
     * @param mobile  移动
     * @return {@link ResponseResult}
     */
    @GetMapping("/{mobile:\\w+}")
    public ResponseResult queryMatchDispatchSetByPhone(@PathVariable("mobile") String mobile, HttpServletRequest request){
        Map param = new HashMap();
        param.put("mobile", mobile);
        param.put("disabled",0);
        return matchDispatchSetService.findMatchDispatchSetByPhone(param);
    }
}
