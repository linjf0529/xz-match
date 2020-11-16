package com.xz.match.entity;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
/**
    * 赛事证书子表 
    */
public class MatchCertificateSublist {
    /**
    * 主键
    */
    private Long id;

    /**
    * 证书ID 可以绑定赛事的默认证书模板
    */
    private Long certificateId;

    /**
    * 成绩参数配置表id
    */
    private Long scoreId;

    /**
    * 参数在证书的位置 X轴
    */
    private String positionX;

    /**
    * 参数在证书的位置 Y轴
    */
    private String positionY;

    /**
    * 字号
    */
    private String fontSize;

    /**
    * 颜色
    */
    private String colour;

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

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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