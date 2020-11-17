package com.xz.match.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 物资发放信息
 *
 * @author gaorh
 * @create 2020-11-14
 */
public class MatchProductDispatchInfoVO implements Serializable {
    private static final long serialVersionUID = -2589126217461321874L;

    /**
     * 报名信息
     */
    List<MatchProductDispatchVO> matchProductList;
    /**
     * 物资清单
     */
    private MatchProductReceiveSetVO signRecordInfo;

    public MatchProductDispatchInfoVO() {
    }

    public List<MatchProductDispatchVO> getMatchProductList() {
        return matchProductList;
    }

    public void setMatchProductList(List<MatchProductDispatchVO> matchProductList) {
        this.matchProductList = matchProductList;
    }

    public MatchProductReceiveSetVO getSignRecordInfo() {
        return signRecordInfo;
    }

    public void setSignRecordInfo(MatchProductReceiveSetVO signRecordInfo) {
        this.signRecordInfo = signRecordInfo;
    }

    @Override
    public String toString() {
        return "MatchProductDispatchInfoVO{" +
                "signRecordInfo=" + signRecordInfo +
                ", matchProductList=" + matchProductList +
                '}';
    }
}
