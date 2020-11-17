package com.xz.match.entity;

import java.math.BigDecimal;

/**
 *
 * @author chenwf
 * @date 2020/11/17
 */

/**
 * 报名记录表
 */
public class SignRecord {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 租户Id
     */
    private Long tenantId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 赛事Id
     */
    private Long matchId;

    /**
     * 科目ID
     */
    private Long subjectId;

    /**
     * 报名用户ID
     */
    private Long userId;

    /**
     * 参赛体ID（个体为用户表userId，团体为团队表teamId）
     */
    private String joinUserId;

    /**
     * 赛制类型（0-个人,1-团体）
     */
    private Integer type;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别（0-女,1-男,2-'）
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 证件号
     */
    private String certificateNo;

    /**
     * 支付状态（0-未支付,1-已支付,2-已取消,3-退款中,4-已退款）
     */
    private Integer payment;

    /**
     * 审核状态(0-不通过,1-成功,2-已取消)
     */
    private Integer review;

    /**
     * 抽签状态(0-抽取中,1-抽中,2-未抽中)
     */
    private Boolean drawState;

    /**
     * 是否通过(0-未通过, 1-已通过)
     */
    private Boolean isPass;

    /**
     * 驳回原因
     */
    private String remarks;

    /**
     * 报名渠道
     */
    private String channel;

    /**
     * 支付方式：1-运动豆、2-场馆卡、3-次卡、4-支付宝、5-微信支付、6-红包支付、7-线下支付、8-租户会员卡、9-第三方支付
     */
    private Integer paymentType;

    /**
     * 支付时间
     */
    private Long paymentTime;

    /**
     * 是否领取(0-未领取，1-已领取)
     */
    private Boolean receive;

    /**
     * 优惠券id
     */
    private String couponId;

    /**
     * 优惠金额
     */
    private BigDecimal couponAmount;

    /**
     * 是否确认支付0否 1是
     */
    private Integer confirmPay;

    /**
     * 退款金额
     */
    private Long refundAmount;

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
    private Long creatorId;

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
    private Long updaterId;

    /**
     * 修改人名称
     */
    private String updatedBy;

    /**
     * 是否可用
     */
    private Integer available;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 赛事名称
     */
    private String matchName;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 邀请码
     */
    private String invitationCode;

    /**
     * 签到
     */
    private Boolean signIn;

    /**
     * 报名费
     */
    private Long expenses;

    /**
     * 报名记录类型(0-个人，1-队长, 2-队员)
     */
    private Integer memberType;

    /**
     * 参赛号码
     */
    private String matchNo;

    /**
     * 成绩排名
     */
    private Integer gradeNo;

    /**
     * 是否分账（0-未分账、1-已分账）
     */
    private Boolean separateAccounts;

    /**
     * 分账时间
     */
    private Long separateAccountsTime;

    /**
     * 是否身份核验成功0否 1是
     */
    private Integer identityCheck;

    /**
     * 参赛人员物资发放状态：，2-部分发放，1-已发放，0-未发放
     */
    private Integer status;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getJoinUserId() {
        return joinUserId;
    }

    public void setJoinUserId(String joinUserId) {
        this.joinUserId = joinUserId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Boolean getDrawState() {
        return drawState;
    }

    public void setDrawState(Boolean drawState) {
        this.drawState = drawState;
    }

    public Boolean getIsPass() {
        return isPass;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Long getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Long paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Boolean getReceive() {
        return receive;
    }

    public void setReceive(Boolean receive) {
        this.receive = receive;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Integer getConfirmPay() {
        return confirmPay;
    }

    public void setConfirmPay(Integer confirmPay) {
        this.confirmPay = confirmPay;
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
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

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public Boolean getSignIn() {
        return signIn;
    }

    public void setSignIn(Boolean signIn) {
        this.signIn = signIn;
    }

    public Long getExpenses() {
        return expenses;
    }

    public void setExpenses(Long expenses) {
        this.expenses = expenses;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(String matchNo) {
        this.matchNo = matchNo;
    }

    public Integer getGradeNo() {
        return gradeNo;
    }

    public void setGradeNo(Integer gradeNo) {
        this.gradeNo = gradeNo;
    }

    public Boolean getSeparateAccounts() {
        return separateAccounts;
    }

    public void setSeparateAccounts(Boolean separateAccounts) {
        this.separateAccounts = separateAccounts;
    }

    public Long getSeparateAccountsTime() {
        return separateAccountsTime;
    }

    public void setSeparateAccountsTime(Long separateAccountsTime) {
        this.separateAccountsTime = separateAccountsTime;
    }

    public Integer getIdentityCheck() {
        return identityCheck;
    }

    public void setIdentityCheck(Integer identityCheck) {
        this.identityCheck = identityCheck;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}