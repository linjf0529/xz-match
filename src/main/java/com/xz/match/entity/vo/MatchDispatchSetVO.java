package com.xz.match.entity.vo;

import com.alibaba.fastjson.JSONArray;
import com.xz.match.entity.MatchDispatchSet;

import java.io.Serializable;

/**
 * 发放人员配置表VO
 *
 * @author chenwf
 * @create 2020-11-17
 */
public class MatchDispatchSetVO  extends MatchDispatchSet implements Serializable {

    private static final long serialVersionUID = -4559120650136149930L;

    private JSONArray matchDispatchPermission;

    public JSONArray getMatchDispatchPermission() {
        return matchDispatchPermission;
    }

    public void setMatchDispatchPermission(JSONArray matchDispatchPermission) {
        this.matchDispatchPermission = matchDispatchPermission;
    }

}
