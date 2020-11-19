package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.SignRecord;
import com.xz.match.entity.vo.MatchDispatchSetVO;
import com.xz.match.service.MatchDispatchSetService;
import com.xz.match.service.SignRecordService;
import com.xz.match.utils.RedisClient;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.aop.AllowAnonymous;
import com.xz.match.utils.exception.CommonException;
import org.springframework.util.ObjectUtils;
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
    @Resource
    private SignRecordService signRecordService;

    /**
     * 创建发放人员配置
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @AllowAnonymous
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
    @AllowAnonymous
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult deleteMatchDispatchSet(@PathVariable("id") Long id, HttpServletRequest request){
        return matchDispatchSetService.removeMatchDispatchSet(id);
    }

    /**
     * 编辑发放人员配置
     *
     * @param request            请求
     * @param matchDispatchSetVO 匹配调度组签证官
     * @return {@link ResponseResult}
     */
    @AllowAnonymous
    @PutMapping
    public ResponseResult editMatchDispatchSet(@RequestBody MatchDispatchSetVO matchDispatchSetVO, HttpServletRequest request){
        if(matchDispatchSetVO == null){
            throw new CommonException("请求参数出错");
        }
        return matchDispatchSetService.modifyMatchDispatchSet(matchDispatchSetVO);
    }

    /**
     * 查询发放人员配置
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @AllowAnonymous
    @GetMapping("/info")
    public ResponseResult queryMatchDispatchSet(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        param.put("disabled",0);
        return matchDispatchSetService.findMatchDispatchSet(getPageParam(request),param);
    }

    /**
     * 通过电话查询发放人员
     *
     * @param request  请求
     * @param recordId 记录id
     * @return {@link ResponseResult}
     */
    @AllowAnonymous
    @GetMapping
    public ResponseResult queryMatchDispatchSetByPhone(@RequestParam("recordId") Long recordId,HttpServletRequest request){
        SignRecord signRecord = signRecordService.selectByPrimaryKey(recordId);
        Map param = new HashMap();
        if(!ObjectUtils.isEmpty(signRecord)){
            if(signRecord.getPhone() == null){
                throw new CommonException("报名信息未填写手机号");
            }
            param.put("mobile", signRecord.getPhone());
            param.put("disabled",0);
        }
        return matchDispatchSetService.findMatchDispatchSetByPhone(signRecord.getSubjectId().toString(),param);
    }
    /**
     * 获取发放人员权限
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @AllowAnonymous
    @GetMapping("/permission")
    public ResponseResult fetchMatchDispatchPermissionById(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        return matchDispatchSetService.findMatchDispatchSetById(param);
    }

}
