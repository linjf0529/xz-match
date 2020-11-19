package com.xz.match.entity.vo;

import com.xz.match.entity.ReserveSublist;

/**
 * @program: xz-match
 * @description:
 * @author: Linjf
 * @create date: 2020-11-18 20:31
 **/
public class ReserveSublistVO extends ReserveSublist {
    private String reserveTime;
    /**
     * 0.可预约 1.预约已满 2.已过期
     */
    private Integer state;

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
