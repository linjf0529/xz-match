package com.xz.match.entity;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
/**
    * 成绩参数配置表 
    */
public class MatchScoreConfig {
    /**
    * 主键
    */
    private Long id;

    /**
    * 科目id
    */
    private Long subjectId;

    /**
    * 类型1.固定参数2.可变参数
    */
    private Integer type;

    /**
    * 是否在成绩配置的时候显示1.显示2.不显示
    */
    private Integer showState;

    /**
    * 成绩参数
    */
    private String scoreParameter;

    /**
    * 排序
    */
    private Integer sort;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getShowState() {
        return showState;
    }

    public void setShowState(Integer showState) {
        this.showState = showState;
    }

    public String getScoreParameter() {
        return scoreParameter;
    }

    public void setScoreParameter(String scoreParameter) {
        this.scoreParameter = scoreParameter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
}