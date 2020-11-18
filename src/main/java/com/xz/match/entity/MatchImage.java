package com.xz.match.entity;

import java.util.List;

/**
 *
 * @author chenwf
 * @date 2020/11/17
 */  
public class MatchImage {
    private Long id;

    /**
    * 赛事id
    */
    private Long matchId;

    /**
    * 项目Id
    */
    private Long subjectId;

    /**
    * 图片路径
    */
    private String url;

    /**
    * 参赛号
    */
    private String matchNo;

    /**
    * 最后更新时间
    */
    private Long lastAccess;

    /**
    * 创建时间
    */
    private Long createdTime;

    private Integer sort;

    private List<String> backgroundURL;

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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(String matchNo) {
        this.matchNo = matchNo;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<String> getBackgroundURL() {
        return backgroundURL;
    }

    public void setBackgroundURL(List<String> backgroundURL) {
        this.backgroundURL = backgroundURL;
    }
}