package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.SignRecord;
import com.xz.match.entity.SignRecordFieldTable;
import com.xz.match.entity.vo.MatchProductDispatchVO;
import com.xz.match.service.MatchProductDispatchService;
import com.xz.match.service.SignRecordFieldTableService;
import com.xz.match.service.SignRecordService;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物资发放facade
 *
 * @author gaorh
 * @create 2020-11-13
 */

@RestController
@RequestMapping("/match/products")
public class MatchProductDispatchController extends BaseController{

    @Resource
    private SignRecordService signRecordService;

    @Resource
    private MatchProductDispatchService matchProductDispatchService;

    @Resource
    private SignRecordFieldTableService signRecordFieldTableService;

    /**
     * 创建发放信息
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @PostMapping("/dispatch")
    public ResponseResult createMatchProductDispatch(@RequestBody MatchProductDispatchVO matchProductDispatchVO, HttpServletRequest request)  {
        ValidateUtils.notNull(matchProductDispatchVO, "请求参数出错");
        ValidateUtils.notNull(matchProductDispatchVO.getProductId(), "物资ID为空");
        String currentUserName = getCurrentUserName(request);
        return matchProductDispatchService.addMatchProductDispatch(matchProductDispatchVO,currentUserName);
    }

    /**
     * 查询赛事报名信息
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @GetMapping("/dispatch/sign")
    public ResponseResult queryMatchSignRecord(HttpServletRequest request)  {
        PageParam page = getPageParam(request);
        JSONObject param = getJSONObject(request);

//        param.put("subjectId", "d275a322f26d11eaaa7cfa163eba29ed");
//        param.put("isPass", true);
//        param.put("review", 1);
        param.put("appointmentTimeMark", 1);//该表示用户判断是否要区预约时间
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<SignRecord> dataList = signRecordService.findBy(param);
        PageInfo<SignRecord> pageInfo = new PageInfo<SignRecord>(dataList);
        for(SignRecord signRecord:pageInfo.getList()){
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("recordId", signRecord.getId());
            List<SignRecordFieldTable> recordFieldTables = signRecordFieldTableService.findBy(paramMap);
            signRecord.setSignRecordInfo(recordFieldTables);
        }
        return ResponseResult.ok().setData(pageInfo);
    }


    /**
     * 查询发放信息
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @GetMapping("/dispatch/info")
    public ResponseResult queryMatchProductDispatch(@RequestParam Long recordId, HttpServletRequest request)  {
        String phone = getCurrentPhone(request);
        return matchProductDispatchService.findMatchProductDispatch(recordId,phone);
    }

    /**
     * 统计参赛人员的物资发放状态
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @GetMapping("/dispatch/statistics")
    public ResponseResult findSignRecordDispatchInfo(HttpServletRequest request) {
        JSONObject param = getJSONObject(request);
//        param.put("isPass", true);
//        param.put("review", "1");
        return matchProductDispatchService.findSignRecordDispatchInfo(param);
    }

    /**
     * 根据productId查看物资发放详情
     *
     * @param productId 产品id
     * @param request   请求
     * @return {@link ResponseResult}
     */
    @GetMapping("/report/info")
    public ResponseResult queryMatchProductDispatchInfoByProductId(@RequestParam("productId") Long productId,HttpServletRequest request) {
        JSONObject param = getJSONObject(request);
        param.put("productId", productId);
        return matchProductDispatchService.findMatchProductDispatchInfoByProductId(param);
    }
}
