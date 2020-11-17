package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.controller.BaseController;
import com.xz.match.entity.vo.MatchProductVO;
import com.xz.match.service.MatchProductService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 物资明细表facade
 *
 * @author gaorh
 * @create 2020-11-05
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
     * 查询物资列表
     *
     * @param request 请求
     * @return {@link ResponseResult}
     
     */
    @GetMapping
    public ResponseResult queryMatchProducts(HttpServletRequest request) {
        JSONObject param = getJSONObject(request);
        return matchProductService.findMatchProducts(getPageParam(request),param);
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
