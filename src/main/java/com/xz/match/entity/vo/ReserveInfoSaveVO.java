package com.xz.match.entity.vo;

import com.xz.match.entity.ReserveInfo;
import com.xz.match.entity.ReserveSublist;

import java.util.List;

/**
 * @program: xz-match
 * @description: 预约管理保存VO
 * @author: Linjf
 * @create date: 2020-11-18 14:56
 **/
public class ReserveInfoSaveVO extends ReserveInfo {
    private List<String> reserveDates;
    private List<ReserveSublist> sublists;

    public List<String> getReserveDates() {
        return reserveDates;
    }

    public void setReserveDates(List<String> reserveDates) {
        this.reserveDates = reserveDates;
    }

    public List<ReserveSublist> getSublists() {
        return sublists;
    }

    public void setSublists(List<ReserveSublist> sublists) {
        this.sublists = sublists;
    }
}
