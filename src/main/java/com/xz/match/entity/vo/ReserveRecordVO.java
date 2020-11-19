package com.xz.match.entity.vo;

import com.xz.match.entity.ReserveRecord;

/**
 * @program: xz-match
 * @description:
 * @author: Linjf
 * @create date: 2020-11-19 08:54
 **/
public class ReserveRecordVO extends ReserveRecord {
    private Long userId;
    private Long subjectId;
    private String name;
    private String certificateNo;
    private String matchNo;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(String matchNo) {
        this.matchNo = matchNo;
    }
}
