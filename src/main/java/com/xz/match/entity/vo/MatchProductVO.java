package com.xz.match.entity.vo;

import com.xz.match.entity.MatchProduct;
import com.xz.match.entity.MatchProductSub;

import java.util.List;

/**
 * 物资明细表VO
 *
 * @author gaorh
 * @create 2020-11-05
 */
public class MatchProductVO extends MatchProduct {


    private static final long serialVersionUID = -6115582568241430441L;

    /**
     * 物资子项
     */
    private List<MatchProductSub> matchProductSubs;

    /**
     * 物资子项名称
     */
    private String productSubName;
    /**
     * 物资库存
     */
    private String stockNumberSub;

    /**
     * 库存发放
     */
    private String dispatchNumberSub;

    public List<MatchProductSub> getMatchProductSubs() {
        return matchProductSubs;
    }

    public void setMatchProductSubs(List<MatchProductSub> matchProductSubs) {
        this.matchProductSubs = matchProductSubs;
    }

    public String getProductSubName() {
        return productSubName;
    }

    public void setProductSubName(String productSubName) {
        this.productSubName = productSubName;
    }

    public String getStockNumberSub() {
        return stockNumberSub;
    }

    public void setStockNumberSub(String stockNumberSub) {
        this.stockNumberSub = stockNumberSub;
    }

    public String getDispatchNumberSub() {
        return dispatchNumberSub;
    }

    public void setDispatchNumberSub(String dispatchNumberSub) {
        this.dispatchNumberSub = dispatchNumberSub;
    }

    @Override
    public String toString() {
        return "MatchProductVO{" +
                "matchProductSubs=" + matchProductSubs +
                ", productSubName='" + productSubName + '\'' +
                ", stockNumberSub='" + stockNumberSub + '\'' +
                ", dispatchNumberSub='" + dispatchNumberSub + '\'' +
                '}';
    }
}
