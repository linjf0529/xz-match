package com.xz.match.entity;

/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
public class ReserveSublist {
    private Long id;

    /**
    * 预约记录表id
    */
    private Long reserveId;

    /**
    * 预约日期
    */
    private String reserveDate;

    /**
    * 预约开始时间
    */
    private String startTime;

    /**
    * 预约结束时间
    */
    private String endTime;

    /**
    * 预约上限
    */
    private Integer reserveLimit;

    /**
    * 已预约人数
    */
    private Integer reserveNumber;

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

    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getReserveLimit() {
        return reserveLimit;
    }

    public void setReserveLimit(Integer reserveLimit) {
        this.reserveLimit = reserveLimit;
    }

    public Integer getReserveNumber() {
        return reserveNumber;
    }

    public void setReserveNumber(Integer reserveNumber) {
        this.reserveNumber = reserveNumber;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }
}