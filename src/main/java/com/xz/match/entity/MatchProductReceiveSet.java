package com.xz.match.entity;

/**
 *
 * @author chenwf
 * @date 2020/11/19
 */

/**
 * 物资领取配置表
 */
public class MatchProductReceiveSet {
    /**
     * 主键
     */
    private Long id;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 赛事名称
     */
    private String matchName;

    /**
     * 赛事id
     */
    private Long matchId;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 科目id
     */
    private Long subjectId;

    /**
     * 页面展示ID
     */
    private String pageShow;

    /**
     * 页面展示参数名
     */
    private String pageShowComment;

    /**
     * 温馨提示内容
     */
    private String tips;

    /**
     * 电子签署内容
     */
    private String signContent;

    /**
     * 领取状态：1-开启，0-关闭
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否禁用
     */
    private Integer disabled;

    /**
     * 是否锁定(0.未锁定,1.已锁定)
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
    private String creatorId;

    /**
     * 创建人名称
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Long createdTime;

    /**
     * 修改人ID
     */
    private String updaterId;

    /**
     * 修改人名称
     */
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getPageShow() {
        return pageShow;
    }

    public void setPageShow(String pageShow) {
        this.pageShow = pageShow;
    }

    public String getPageShowComment() {
        return pageShowComment;
    }

    public void setPageShowComment(String pageShowComment) {
        this.pageShowComment = pageShowComment;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getSignContent() {
        return signContent;
    }

    public void setSignContent(String signContent) {
        this.signContent = signContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
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

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}