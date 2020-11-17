package com.xz.match.entity.vo;

import com.xz.match.entity.MatchProductDispatch;
import com.xz.match.entity.MatchProductSub;

import java.util.List;

/**
 * 物资发放表VO
 *
 * @author gaorh
 * @create 2020-11-13
 */
public class MatchProductDispatchVO extends MatchProductDispatch {

    private static final long serialVersionUID = 1817034888346936558L;

    /**
     * 科目id
     */
    private Long subjectId;

    /**
     * 物资库存
     */
    private String stockNumber;


    private List<MatchProductSub> MatchProductSubList;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public List<MatchProductSub> getMatchProductSubList() {
        return MatchProductSubList;
    }

    public void setMatchProductSubList(List<MatchProductSub> matchProductSubList) {
        MatchProductSubList = matchProductSubList;
    }

}
