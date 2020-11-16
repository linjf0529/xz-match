package com.xz.match.entity;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */

/**
 * 赛事表
 */
public class MatchInfo {
    /**
     * 主键
     */
    private String id;

    /**
     * 赛事名称
     */
    private String matchName;

    private Long lastAccess;

    private Long createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public Long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Long lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }
}