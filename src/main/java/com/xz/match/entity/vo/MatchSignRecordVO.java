package com.xz.match.entity.vo;

import com.xz.match.entity.SignRecord;
import com.xz.match.entity.SignRecordFieldTable;

import java.util.List;

/**
 * 赛事报名VO
 *
 * @author gaorh
 * @create 2020-11-13
 */
public class MatchSignRecordVO extends SignRecord {

    private List<SignRecordFieldTable> signRecordInfo;

    public MatchSignRecordVO() {
    }

    public MatchSignRecordVO(List<SignRecordFieldTable> signRecordInfo) {

        this.signRecordInfo = signRecordInfo;
    }

    public List<SignRecordFieldTable> getSignRecordInfo() {
        return signRecordInfo;
    }

    public void setSignRecordInfo(List<SignRecordFieldTable> signRecordInfo) {
        this.signRecordInfo = signRecordInfo;
    }

}
