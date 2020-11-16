package com.xz.match.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发放人员配置表facade
 *
 * @author gaorh
 * @create 2020-11-15
 */
@RestController
@RequestMapping("/matchs/config")
@Slf4j
public class MatchDispatchSetController{

//    /**
//     * 创建发放人员配置
//     *
//     * @param request 请求
//     * @return {@link ResponseResult}
//     * @throws BusinessException 业务异常
//     */
//    @PostMapping
//    public ResponseResult createMatchDispatchSet(@RequestBody MatchDispatchSetVO matchDispatchSetVO, HttpServletRequest request){
//        log.debug("~~~~~ post param = {}", JSON.toJSONString(matchDispatchSetVO));
//        ValidateUtils.notNull(matchDispatchSetVO, MessageLocale.NOT_NULL);
//        String authId = getCurrentAuthId(request);
//        TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
//        if(ObjectUtils.isEmpty(tenantUser)){
//            return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
//        }else{
//            matchDispatchSetVO.setTenantId(tenantUser.getTenantId());
//        }
//        return matchDispatchSetService.addMatchDispatchSet(matchDispatchSetVO);
//    }
//
//
//    /**
//     * 删除发放人员配置
//     *
//     * @param id      id
//     * @param request 请求
//     * @return {@link ResponseResult}
//     * @throws BusinessException 业务异常
//     */
//    @DeleteMapping("/{id:\\w+}")
//    public ResponseResult deleteMatchDispatchSet(@PathVariable("id") String id, HttpServletRequest request) throws BusinessException{
//        return matchDispatchSetService.removeMatchDispatchSet(id);
//    }
//
//    /**
//     * 编辑发放人员配置
//     *
//     * @param id      id
//     * @param request 请求
//     * @return {@link ResponseResult}
//     * @throws BusinessException 业务异常
//     */
//    @PutMapping
//    public ResponseResult editMatchDispatchSet(@RequestParam String id , HttpServletRequest request) throws BusinessException{
//        return null;
//    }
//
//    /**
//     * 查询发放人员配置
//     *
//     * @param request 请求
//     * @return {@link ResponseResult}
//     * @throws BusinessException 业务异常
//     */
//    @GetMapping
//    public ResponseResult queryMatchDispatchSet(HttpServletRequest request) throws BusinessException{
//        JSONObject param = getJSONObject(request);
//        String authId = getCurrentAuthId(request);
//        TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
//        if(ObjectUtils.isEmpty(tenantUser)){
//            return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
//        }else{
//            param.put("tenantId",tenantUser.getTenantId());
//        }
//        param.put("disabled",0);
//        return matchDispatchSetService.findMatchDispatchSet(getPageParam(request),param);
//    }
//
//    /**
//     * 通过电话查询发放人员
//     *
//     * @param request 请求
//     * @param mobile  移动
//     * @return {@link ResponseResult}
//     * @throws BusinessException 业务异常
//     */
//    @GetMapping("/{mobile:\\w+}")
//    public ResponseResult queryMatchDispatchSetByPhone(@PathVariable("mobile") String mobile, HttpServletRequest request) throws BusinessException{
//        Map param = Maps.newHashMap();
//        param.put("mobile", mobile);
//        param.put("disabled",0);
//        return matchDispatchSetService.findMatchDispatchSetByPhone(param);
//    }
}
