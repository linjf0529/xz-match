package com.xz.match.entity;

/**
 * @author chenwf
 * @date 2020/11/18
 */
public class MatchSubject {
    /**
     * 主键
     */
    private Long id;

    /**
     * 赛事id
     */
    private Long matchId;

    /**
     * 赛事名称
     */
    private String matchName;

    /**
     * 科目名称
     */
    private String subjectName;

    private Long lastAccess;

    private Long createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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