package com.xz.match.entity.vo;

import com.xz.match.entity.SignRecord;

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
     * 物资清单
     */
    List<MatchProductDispatchVO> matchProductList;
    /**
     * 报名信息
     */
    private MatchProductReceiveSetVO signRecordInfo;

    /**
     * 报名表
     */
    private SignRecord signRecord;

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

    public SignRecord getSignRecord() {
        return signRecord;
    }

    public void setSignRecord(SignRecord signRecord) {
        this.signRecord = signRecord;
    }

    @Override
    public String toString() {
        return "MatchProductDispatchInfoVO{" +
                "signRecordInfo=" + signRecordInfo +
                ", matchProductList=" + matchProductList +
                '}';
    }
}
