package com.xz.match.controller;

import com.xz.match.entity.vo.MatchProductReceiveSetVO;
import com.xz.match.service.MatchProductReceiveSetService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.enums.SignFieldState;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 物资领取配置facade
 *
 * @author gaorh
 * @create 2020-11-09
 */
@RestController
@RequestMapping("/match/products")
public class MatchProductReceiveSetController extends BaseController{
    @Resource
    private MatchProductReceiveSetService matchProductReceiveSetService;
    /**
     * 查询赛事所有个人科目
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @GetMapping("/config/single")
    public ResponseResult querySingleMatchSubject(HttpServletRequest request)  {

        Map<String, Object> param = getParameterMap(request);

        // 个人项目
        param.put("type",'0');
        return matchProductReceiveSetService.findMatchProductReceiveSet(getPageParam(request),param);
    }

    /**
     * 查询赛事项目报名字段
     *
     * @param request   请求
     * @param subjectId 项目id
     * @return {@link ResponseResult}
     */
    @GetMapping("/config/{subjectId:\\w+}")
    public ResponseResult queryMatchProductReceiveSetBySubjectId(@PathVariable("subjectId") String subjectId, HttpServletRequest request)  {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("subjectId", subjectId);
        param.put("stateList", new Integer[]{SignFieldState.SIGN_FIELD_STATE_SHOW.getStatus(),SignFieldState.SIGN_FIELD_STATE_REQUIRED.getStatus()});
        return ResponseResult.ok().setData(matchProductReceiveSetService.findMatchProductReceiveSetBySubjectId(param));
    }

    /**
     * 编辑物资领取配置
     *
     * @param matchProductReceiveSetVO 物资领取配置VO
     * @param request                  请求
     * @return {@link ResponseResult}
     */
    @PutMapping("/config")
    public ResponseResult editMatchProductReceiveSet(@RequestBody MatchProductReceiveSetVO matchProductReceiveSetVO, HttpServletRequest request)  {
        ValidateUtils.notNull(matchProductReceiveSetVO, "请求参数出错");


        return matchProductReceiveSetService.modifyMatchProductReceiveSet(matchProductReceiveSetVO);
    }


    /**
     * APP及小程序的物资领取信息
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @GetMapping("/info")
    public ResponseResult queryMatchProductReceiveSet(@RequestParam Long recordId, @RequestParam Long subjectId, HttpServletRequest request)  {
        return matchProductReceiveSetService.findMatchProductReceiveSetByRecordIdAndSubjectId(recordId,subjectId);
    }

    /**
     * 获取微信小程序码
     *
     * @param recordId 记录id
     * @param response 响应
     */
    @GetMapping("/wxCode")
    public void fetchWxCode(@RequestParam String recordId, HttpServletResponse response) {
        byte[] bytes = matchProductReceiveSetService.findWxCode(recordId);
        //二维码输出到页面
        PrintWriter out = null;
        InputStream is = null;
        try {
            out = response.getWriter();
            is = new ByteArrayInputStream(bytes);
            int a = is.read();
            while (a != -1) {
                out.print((char) a);
                a = is.read();
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                out.close();
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
