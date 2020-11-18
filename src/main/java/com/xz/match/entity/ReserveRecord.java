package com.xz.match.entity;

/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
public class ReserveRecord {
    private Long id;

    /**
    * 用户id
    */
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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