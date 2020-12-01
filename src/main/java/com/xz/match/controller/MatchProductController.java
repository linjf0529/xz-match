package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.vo.MatchProductVO;
import com.xz.match.service.MatchProductService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 物资明细表facade
 *
 * @author chenwf
 * @create 2020-11-17
 */
@RestController
@RequestMapping("/match/products")
public class MatchProductController extends BaseController {
    @Resource
    private MatchProductService matchProductService;


    /**
     * 创建物资
     *
     * @param matchProductVO 物资明细VO
     * @param request        请求
     * @return {@link ResponseResult}
     
     */
    @PostMapping
    public ResponseResult createMatchProduct(@RequestBody MatchProductVO matchProductVO, HttpServletRequest request) {
        ValidateUtils.notNull(matchProductVO, "请求参数不能为空");
       
        return matchProductService.addMatchProduct(matchProductVO);
    }

    /**
     * 分页查询物资列表
     *
     * @param request 请求
     * @return {@link ResponseResult}
     
     */
    @GetMapping
    public ResponseResult queryMatchProductsByPage(HttpServletRequest request) {
        JSONObject param = getJSONObject(request);
        return matchProductService.findMatchProductsByPage(getPageParam(request),param);
    }

    /**
     * 查询物资名称
     *
     * @param subjectId 对象id
     * @param request   请求
     * @return {@link ResponseResult}
     */
    @GetMapping("/name")
    public ResponseResult queryMatchProducts(@RequestParam("subjectId") Long subjectId,HttpServletRequest request) {
        Map param = new HashMap<String, Object>();
        param.put("subjectId", subjectId);
        return matchProductService.findMatchProducts(param);
    }
    /**
     * 查询物资发放报表信息
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @GetMapping("/report")
    public ResponseResult queryMatchProductsReport(HttpServletRequest request) {
        JSONObject param = getJSONObject(request);
        return  matchProductService.findMatchProductsReport(getPageParam(request),param);
    }

    /**
     * 根据id查询物资
     *
     * @param id id
     * @return {@link ResponseResult}
     
     */
    @GetMapping("/{id:\\w+}")
    public ResponseResult queryMatchProductById(@PathVariable("id") Long id, HttpServletRequest request) {
        return matchProductService.findMatchProductById(id);
    }

    /**
     * 编辑物资
     *
     * @param matchProductVO 物资明细VO
     * @param request        请求
     * @return {@link ResponseResult}
     */
    @PutMapping
    public ResponseResult editMatchProduct(@RequestBody MatchProductVO matchProductVO, HttpServletRequest request) {

        ValidateUtils.notNull(matchProductVO,"请求参数不能为空");
        ValidateUtils.notNull(matchProductVO.getId(), "物资ID不能为空");
        return matchProductService.modifyMatchProduct(matchProductVO);
    }

    /**
     * 删除物资
     *
     * @return {@link ResponseResult}
     */
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult dropMatchProduct(@PathVariable("id") Long id) {
        return matchProductService.removeMatchProduct(id);
    }
}
