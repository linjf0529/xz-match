package com.xz.match.entity.vo;

import com.xz.match.entity.MatchProductSub;
import com.xz.match.entity.MatchStock;

import java.util.List;

/**
 * 库存明细表VO
 *
 * @author gaorh
 * @create 2020-11-05
 */
public class MatchStockVO extends MatchStock {

    private static final long serialVersionUID = 5792725482740710242L;

    private List<MatchStock> matchStockes;

    private List<MatchProductSub> matchProductSubs;

    public List<MatchStock> getMatchStockes() {
        return matchStockes;
    }

    public void setMatchStockes(List<MatchStock> matchStockes) {
        this.matchStockes = matchStockes;
    }

    public List<MatchProductSub> getMatchProductSubs() {
        return matchProductSubs;
    }

    public void setMatchProductSubs(List<MatchProductSub> matchProductSubs) {
        this.matchProductSubs = matchProductSubs;
    }

    @Override
    public String toString() {
        return "MatchStockVO{" +
                "matchStockes=" + matchStockes +
                ", matchProductSubs=" + matchProductSubs +
                '}';
    }
}
