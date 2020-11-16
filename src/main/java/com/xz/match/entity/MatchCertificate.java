package com.xz.match.entity;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
/**
    * 赛事证书表 
    */
public class MatchCertificate {
    /**
    * 主键
    */
    private Long id;

    /**
    * 赛事id 可以帮定赛事的默认证书模板
    */
    private Long matchId;

    /**
    * 科目id
    */
    private Long subjectId;

    /**
    * 证书背景图地址
    */
    private String url;

    /**
    * 是否锁定 (0.未锁定,1.已锁定)
    */
    private Boolean locked;

    /**
    * 版本号
    */
    private Integer version;

    /**
    * 最后更新时间
    */
    private Long lastAccess;

    /**
    * 创建人ID
    */
    private Long creatorId;

    /**
    * 创建人
    */
    private String createdBy;

    /**
    * 创建时间
    */
    private Long createdTime;

    /**
    * 更新人ID
    */
    private Long updaterId;

    /**
    * 更新人
    */
    private String updatedBy;

    /**
    * 证书类型 1.赛事证书 2.项目证书
    */
    private Boolean type;

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

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Long lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}