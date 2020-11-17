package com.xz.match.controller;

import com.xz.match.entity.vo.MatchProductSubVO;
import com.xz.match.service.MatchProductSubService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

/**
 * 物资子项明细表facade
 *
 * @author chenwf
 * @create 2020-11-17
 */
@RestController
@RequestMapping("/match/products/sub")
public class MatchProductSubController {

    @Resource
    private MatchProductSubService matchProductSubService;

    /**
     * 新增物资子项
     *
     * @param matchProductSubVO 物资子项VO
     * @param request             请求
     * @return {@link ResponseResult}
     */

    // TODO 暂时无需实现
    @PostMapping
    public ResponseResult createMatchProductSub(@RequestBody MatchProductSubVO matchProductSubVO, HttpServletRequest request) {
        return null;
    }

    /**
     *  根据id查询物资子项
     *
     * @param id      id
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @GetMapping
    public ResponseResult queryMatchProductSubById(@PathParam("id") Long id, HttpServletRequest request) {
        return matchProductSubService.findMatchProductSubById(id);
    }

    /**
     * 编辑物资子项
     *
     * @param matchProductSubVO 物资子项VO
     * @param request             请求
     * @return {@link ResponseResult}
     */
    @PutMapping
    public ResponseResult editMatchProductSub(@RequestBody MatchProductSubVO matchProductSubVO, HttpServletRequest request) {
        ValidateUtils.notNull(matchProductSubVO, "请求参数出错");
        ValidateUtils.notNull(matchProductSubVO.getId(), "物资ID不能为空");

        return matchProductSubService.modifyMatchProductSub(matchProductSubVO);
    }

    /**
     * 删除物资子项
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult dropMatchProductSub(@PathVariable("id") Long id, HttpServletRequest request) {
        return matchProductSubService.removeMatchProductSub(id);
    }
}
