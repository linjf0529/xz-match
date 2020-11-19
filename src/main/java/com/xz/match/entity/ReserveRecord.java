package com.xz.match.entity;

/**
 * @author chenwf
 * @date 2020/11/19
 */
public class ReserveRecord {
    private Long id;

    /**
     * 报名记录id
     */
    private Long recordId;

    /**
     * 预约时段表id
     */
    private Long reserveSubId;

    /**
     * 创建时间
     */
    private Long createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getReserveSubId() {
        return reserveSubId;
    }

    public void setReserveSubId(Long reserveSubId) {
        this.reserveSubId = reserveSubId;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }
}