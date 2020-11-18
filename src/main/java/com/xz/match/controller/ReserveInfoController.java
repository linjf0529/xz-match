package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.ReserveInfo;
import com.xz.match.entity.ReserveSublist;
import com.xz.match.entity.vo.ReserveInfoSaveVO;
import com.xz.match.service.ReserveInfoService;
import com.xz.match.service.ReserveSublistService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: xz-match
 * @description: 物质领取预约
 * @author: Linjf
 * @create date: 2020-11-18 14:48
 **/
@RestController
@RequestMapping("/reserve/info")
public class ReserveInfoController extends BaseController{
    @Resource
    private ReserveInfoService reserveInfoService;

    @Resource
    private ReserveSublistService reserveSublistService;

    /**
     * 预约管理列表
     * @param request
     * @return
     */
    @GetMapping
    public ResponseResult findReserveInfo(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        return ResponseResult.ok().setData(reserveInfoService.findBy(getPageParam(request),param));
    }

    @GetMapping("/details")
    public ResponseResult getReserveInfo(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        Long id=param.getLong("id");
        ValidateUtils.notNull(id,"id不能为空");
        ReserveInfoSaveVO vo=new ReserveInfoSaveVO();
        ReserveInfo reserveInfo=reserveInfoService.selectByPrimaryKey(id);
        vo.setId(reserveInfo.getId());
        vo.setMatchId(reserveInfo.getMatchId());
        vo.setMatchName(reserveInfo.getMatchName());
        vo.setSubjectId(reserveInfo.getSubjectId());
        vo.setSubjectName(reserveInfo.getSubjectName());
        vo.setLatitude(reserveInfo.getLatitude());
        vo.setLongitude(reserveInfo.getLongitude());
        vo.setAddress(reserveInfo.getAddress());
        vo.setReserveDate(reserveInfo.getReserveDate());
        Map<String,Object> map=new HashMap<>();
        map.put("reserveId",id);
        vo.setSublists(reserveSublistService.findBy(map));
        return ResponseResult.ok().setData(reserveInfoService.findBy(getPageParam(request),param));
    }

    /**
     * 预约管理保存
     * @param reserveInfoSaveVO
     * @return
     */
    @PostMapping
    public ResponseResult saveReserveInfo(@RequestBody ReserveInfoSaveVO reserveInfoSaveVO){
        ValidateUtils.notNull(reserveInfoSaveVO,"参数异常");
        ValidateUtils.notNull(reserveInfoSaveVO.getReserveDates(),"预约日期不能为空");
        ValidateUtils.notNull(reserveInfoSaveVO.getSublist(),"预约时间段不能为空");
        ReserveInfo reserveInfo=new ReserveInfo();
        reserveInfo.setMatchId(reserveInfoSaveVO.getMatchId());
        reserveInfo.setMatchName(reserveInfoSaveVO.getMatchName());
        reserveInfo.setSubjectId(reserveInfoSaveVO.getSubjectId());
        reserveInfo.setSubjectName(reserveInfoSaveVO.getSubjectName());
        reserveInfo.setAddress(reserveInfoSaveVO.getAddress());
        reserveInfo.setLatitude(reserveInfoSaveVO.getLatitude());
        reserveInfo.setLongitude(reserveInfoSaveVO.getLongitude());
        for (String reserveDate:reserveInfoSaveVO.getReserveDates()){
            reserveInfo.setReserveDate(reserveDate);
            reserveInfo.setCreatedTime(new Date().getTime());
            reserveInfoService.insert(reserveInfo);
            for(ReserveSublist reserveSublist:reserveInfoSaveVO.getSublists()){
                reserveSublist.setReserveId(reserveInfo.getId());
                reserveSublist.setReserveDate(reserveDate);
                reserveSublist.setCreatedTime(new Date().getTime());
                reserveSublistService.insert(reserveSublist);
            }
            reserveInfo.setId(null);
        }
        return ResponseResult.ok();
    }

    /**
     * 预约管理修改
     * @param reserveInfo
     * @return
     */
    @PutMapping
    public ResponseResult updateReserveInfo(@RequestBody ReserveInfo reserveInfo){
        ValidateUtils.notNull(reserveInfo,"参数异常");
        ValidateUtils.notNull(reserveInfo.getSublist(),"预约时间不能为空");
        reserveInfoService.updateByPrimaryKeySelective(reserveInfo);
        reserveSublistService.updateByPrimaryKeySelective(reserveInfo.getSublist());
        return ResponseResult.ok();
    }

    /**
     * 删除预约管理
     * @param id
     * @param request
     * @return
     */
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult deleteReserveInfo(@PathVariable("id") Long id, HttpServletRequest request){
        ReserveSublist reserveSublist=reserveSublistService.selectByPrimaryKey(id);
        reserveSublistService.deleteByPrimaryKey(id);
        Map<String,Object> map=new HashMap<>();
        map.put("reserveId",reserveSublist.getReserveId());
        return ResponseResult.ok();
    }
}
