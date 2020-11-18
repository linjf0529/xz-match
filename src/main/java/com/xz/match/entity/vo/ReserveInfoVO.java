package com.xz.match.entity.vo;

import com.xz.match.entity.ReserveInfo;

/**
 * @program: xz-match
 * @description: 预约管理详情
 * @author: Linjf
 * @create date: 2020-11-18 14:35
 **/
public class ReserveInfoVO extends ReserveInfo {
    /**
     * 子表Id
     */
    private String subListId;
    /**
     * 预约时间
     */
    private String reserveDateTime;
    /**
     * 预约上限
     */
    private Integer reserveLimit;

    /**
     * 已预约人数
     */
    private Integer reserveNumber;

    public String getSubListId() {
        return subListId;
    }

    public void setSubListId(String subListId) {
        this.subListId = subListId;
    }

    public String getReserveDateTime() {
        return reserveDateTime;
    }

    public void setReserveDateTime(String reserveDateTime) {
        this.reserveDateTime = reserveDateTime;
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
}
