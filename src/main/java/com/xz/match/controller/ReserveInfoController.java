package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.ReserveInfo;
import com.xz.match.entity.ReserveRecord;
import com.xz.match.entity.ReserveSublist;
import com.xz.match.entity.SignRecord;
import com.xz.match.entity.vo.ReserveInfoSaveVO;
import com.xz.match.entity.vo.ReserveRecordVO;
import com.xz.match.entity.vo.ReserveSublistVO;
import com.xz.match.service.ReserveInfoService;
import com.xz.match.service.ReserveRecordService;
import com.xz.match.service.ReserveSublistService;
import com.xz.match.service.SignRecordService;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.StringUtils;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.aop.AllowAnonymous;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    private SignRecordService signRecordService;

    @Resource
    private ReserveRecordService reserveRecordService;

    /**
     * 预约管理列表
     * @param request
     * @return
     */
    @AllowAnonymous
    @GetMapping
    public ResponseResult findReserveInfo(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        return reserveInfoService.findBy(getPageParam(request),param);
    }
    @AllowAnonymous
    @GetMapping("/details")
    public ResponseResult getReserveInfo(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        Long id=param.getLong("id");
        ValidateUtils.notNull(id,"id不能为空");
        Long subListId=param.getLong("subListId");
        ValidateUtils.notNull(subListId,"subListId不能为空");
        ReserveInfo reserveInfo=reserveInfoService.selectByPrimaryKey(id);
        reserveInfo.setSublist(reserveSublistService.selectByPrimaryKey(subListId));
        return ResponseResult.ok().setData(reserveInfo);
    }

    /**
     * 预约管理保存
     * @param reserveInfoSaveVO
     * @return
     */
    @AllowAnonymous
    @PostMapping
    public ResponseResult saveReserveInfo(@RequestBody ReserveInfoSaveVO reserveInfoSaveVO){
        ValidateUtils.notNull(reserveInfoSaveVO,"参数异常");
        ValidateUtils.notNull(reserveInfoSaveVO.getReserveDates(),"预约日期不能为空");
        ValidateUtils.notNull(reserveInfoSaveVO.getSublists(),"预约时间段不能为空");
        ReserveInfo reserveInfo=new ReserveInfo();
        reserveInfo.setMatchId(reserveInfoSaveVO.getMatchId());
        reserveInfo.setMatchName(reserveInfoSaveVO.getMatchName());
        reserveInfo.setSubjectId(reserveInfoSaveVO.getSubjectId());
        reserveInfo.setSubjectName(reserveInfoSaveVO.getSubjectName());
        reserveInfo.setAddress(reserveInfoSaveVO.getAddress());
        reserveInfo.setLatitude(reserveInfoSaveVO.getLatitude());
        reserveInfo.setLongitude(reserveInfoSaveVO.getLongitude());
        reserveInfo.setCreatedTime(new Date().getTime());
        reserveInfoService.insertSelective(reserveInfo);
        for (String reserveDate:reserveInfoSaveVO.getReserveDates()){
            reserveInfo.setCreatedTime(new Date().getTime());
            for(ReserveSublist reserveSublist:reserveInfoSaveVO.getSublists()){
                reserveSublist.setReserveId(reserveInfo.getId());
                reserveSublist.setReserveDate(reserveDate);
                reserveSublist.setCreatedTime(new Date().getTime());
                reserveSublist.setReserveNumber(0);
                reserveSublistService.insertSelective(reserveSublist);
            }
        }
        return ResponseResult.ok();
    }

    /**
     * 预约管理修改
     * @param reserveInfo
     * @return
     */
    @AllowAnonymous
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
    @AllowAnonymous
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult deleteReserveInfo(@PathVariable("id") Long id, HttpServletRequest request){
        ReserveSublist reserveSublist=reserveSublistService.selectByPrimaryKey(id);
        reserveSublistService.deleteByPrimaryKey(id);
        Map<String,Object> map=new HashMap<>();
        map.put("reserveId",reserveSublist.getReserveId());
        List<ReserveSublist> reserveSublistList=reserveSublistService.findBy(map);
        if(reserveSublistList==null || reserveSublistList.size()<1){
            reserveInfoService.deleteByPrimaryKey(reserveSublist.getReserveId());
        }
        return ResponseResult.ok();
    }
    /**
     * 预约管理列表
     * @param request
     * @return
     */
    @AllowAnonymous
    @GetMapping("/date")
    public ResponseResult findReserveSubListDate(HttpServletRequest request) throws ParseException {
        JSONObject param = getJSONObject(request);
        PageParam pageParam=getPageParam(request);
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
        Long subjectId=param.getLong("subjectId");
        ValidateUtils.notNull(subjectId,"项目id不能为空");
        List<ReserveSublistVO> dateSublist=reserveSublistService.getReserveDate(subjectId);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date newDate=sdf.parse(sdf.format(new Date()));
        Date endDate;
        if(dateSublist!=null){
            Map<String,Object> map=new HashMap<>();
            for(int i=0;i<dateSublist.size();i++){
                dateSublist.get(i).setState(1);
                endDate=sdf.parse(dateSublist.get(i).getReserveDate());
                if (endDate.before(newDate)){
                    dateSublist.get(i).setState(2);
                    continue;
                }
                map.put("reserveId",dateSublist.get(i).getReserveId());
                map.put("reserveDate",dateSublist.get(i).getReserveDate());
                List<ReserveSublistVO> timeSublist=reserveSublistService.getReserveTime(map);
                for(ReserveSublistVO timeVo:timeSublist){
                    if(timeVo.getState()==0){
                        dateSublist.get(i).setState(0);
                    }
                }
            }
        }
        return ResponseResult.ok().setData(new PageInfo<>(dateSublist));
    }

    @AllowAnonymous
    @GetMapping("/time")
    public ResponseResult findReserveSubListTime(HttpServletRequest request) throws ParseException {
        JSONObject param = getJSONObject(request);
        PageParam pageParam=getPageParam(request);
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
        List<ReserveSublistVO> timeSublist=reserveSublistService.getReserveTime(param);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date newDate=sdf.parse(sdf.format(new Date()));
        Date endDate;
        for(int i=1;i<timeSublist.size();i++){
            endDate=sdf.parse(timeSublist.get(i).getReserveDate()+" "+timeSublist.get(i).getEndTime());
            if(endDate.before(newDate)){
                timeSublist.get(i).setState(2);
            }
        }
        return ResponseResult.ok().setData(new PageInfo<>(timeSublist));
    }

    /**
     * 预约
     * @param reserveRecordVO
     * @return
     */
    @AllowAnonymous
    @PostMapping("/record")
    public ResponseResult saveReserveRecord(@RequestBody ReserveRecordVO reserveRecordVO){
        ValidateUtils.notNull(reserveRecordVO,"参数异常");
        ValidateUtils.notNull(reserveRecordVO.getUserId(),"用户id不能为空");
        ValidateUtils.notNull(reserveRecordVO.getSubjectId(),"项目id不能为空");
        ValidateUtils.notNull(reserveRecordVO.getReserveSubId(),"预约时间段id不能为空");
        JSONObject object=new JSONObject();
        object.put("userId",reserveRecordVO.getUserId());
        object.put("subjectId",reserveRecordVO.getSubjectId());
        List<SignRecord> signRecords=signRecordService.findBy(object);
        ValidateUtils.notNull(signRecords,"未找到用户在该项目的报名记录,无法预约!");
        Long recordId=signRecords.get(0).getId();
        Map<String,Object> map=new HashMap<>();
        map.put("recordId",recordId);
        List<ReserveRecordVO> reserveRecordList=reserveRecordService.findBy(map);
        ReserveRecord reserveRecord=new ReserveRecord();
        Long reserveSubId=reserveRecordVO.getReserveSubId();
        ReserveSublist reserveSublist=reserveSublistService.selectByPrimaryKey(reserveSubId);
        ValidateUtils.notNull(reserveSublist,"找不到该预约时间段");
        if(reserveSublist.getReserveLimit()!=null){
            ValidateUtils.isFalse(reserveSublist.getReserveNumber()>=reserveSublist.getReserveLimit(),0,"该时间段预约已满");
        }
        if(reserveRecordList==null || reserveRecordList.size()==0){
            reserveRecord.setRecordId(recordId);
            reserveRecord.setReserveSubId(reserveSubId);
            reserveRecord.setCreatedTime(new Date().getTime());
            reserveRecord.setAppointmentTime(reserveSublist.getReserveDate()+" "+reserveSublist.getStartTime()+"-"+reserveSublist.getEndTime());
            reserveRecordService.insertSelective(reserveRecord);
        }else {
            reserveRecord=reserveRecordList.get(0);
            ReserveSublist oldReserveSublist=reserveSublistService.selectByPrimaryKey(reserveRecord.getReserveSubId());
            reserveRecord.setReserveSubId(reserveSubId);
            reserveRecord.setCreatedTime(new Date().getTime());
            reserveRecord.setAppointmentTime(reserveSublist.getReserveDate()+" "+reserveSublist.getStartTime()+"-"+reserveSublist.getEndTime());
            reserveRecordService.updateByPrimaryKey(reserveRecord);
            if(oldReserveSublist!=null){
                oldReserveSublist.setReserveNumber(oldReserveSublist.getReserveNumber()-1);
            }
            reserveSublistService.updateByPrimaryKeySelective(oldReserveSublist);
        }
        if (reserveSublist.getReserveNumber()!=null){
            reserveSublist.setReserveNumber(reserveSublist.getReserveNumber()+1);
        }else {
            reserveSublist.setReserveNumber(1);
        }
        reserveSublistService.updateByPrimaryKeySelective(reserveSublist);
        return ResponseResult.ok();
    }
    /**
     * 预约人员列表
     * @param request
     * @return
     */
    @AllowAnonymous
    @GetMapping("/record")
    public ResponseResult getReserveRecord(HttpServletRequest request){
        PageParam pageParam=getPageParam(request);
        JSONObject param=getJSONObject(request);
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
        List<ReserveRecordVO> reserveRecordVOList= reserveRecordService.findBy(param);
        return ResponseResult.ok().setData(new PageInfo<>(reserveRecordVOList));
    }

    /**
     * 获取导航信息
     * @param request
     * @return
     */
    @AllowAnonymous
    @GetMapping("/getLocalInfo")
    public ResponseResult getLocalInfo(@RequestParam Long subjectId, HttpServletRequest request){
        ReserveInfo reserveInfo = reserveInfoService.getLocalInfo(subjectId);
        return ResponseResult.ok().setData(reserveInfo);
    }
    /**
     * 获取导航信息
     * @param request
     * @return
     */
    @AllowAnonymous
    @GetMapping("/getReserveDate")
    public ResponseResult getReserveDate(HttpServletRequest request){
        Map<String,String> map=new HashMap<>();
        map.put("reserveDate","");
        map.put("reserveTime","");
        JSONObject param=getJSONObject(request);
        List<SignRecord> signRecords=signRecordService.findBy(param);
        if(signRecords!=null && signRecords.size()>0){
            param.put("recordId",signRecords.get(0).getId());
            List<ReserveRecordVO> reserveRecordVOList= reserveRecordService.findBy(param);
            for(ReserveRecordVO reserveRecordVO:reserveRecordVOList){
                if(StringUtils.isNotEmpty(reserveRecordVO.getAppointmentTime())){
                    reserveRecordVO.getAppointmentTime();
                    String[] str = reserveRecordVO.getAppointmentTime().split(" ");
                    map.put("reserveDate",str[0]);
                    map.put("reserveTime",str[1]);
                }
            }
        }
        return ResponseResult.ok().setData(map);
    }

}
