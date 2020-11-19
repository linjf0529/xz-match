package com.xz.match.controller;

import com.xz.match.entity.vo.MatchStockVO;
import com.xz.match.service.MatchStockService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.aop.AllowAnonymous;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

/**
 * 库存明细表
 *
 * @author chenwf
 * @create 2020-11-17
 */
@RestController
@RequestMapping("/match/stockes")
public class MatchStockController {
    @Resource
    private MatchStockService matchStockService;

    /**
     * 创建库存
     *
     * @param matchStockVO 库存VO
     * @param request      请求
     * @return {@link ResponseResult}
     */
    @PostMapping
    public ResponseResult createMatchStock(@RequestBody MatchStockVO matchStockVO, HttpServletRequest request) {
        ValidateUtils.notNull(matchStockVO, "请求参数出错");
        return matchStockService.addMatchStock(matchStockVO);
    }

    /**
     * 查询及调整物资库存
     *
     * @param request   请求
     * @param productId 产品id
     * @return {@link ResponseResult}
     */
    @GetMapping
    public ResponseResult queryMatchStockes(@PathParam("productId") Long productId, HttpServletRequest request) {
        return matchStockService.findMatchStock(productId);
    }
}
