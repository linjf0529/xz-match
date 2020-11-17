package com.xz.match.entity.vo;


import com.xz.match.entity.MatchProduct;
import com.xz.match.entity.SignRecordFieldTable;
import com.xz.match.entity.SubjectSignField;

import java.io.Serializable;
import java.util.List;

/**
 * 物资领取配置表VO
 *
 * @author gaorh
 * @create 2020-11-09
 */
public class MatchProductReceiveSetVO  implements Serializable {

    private static final long serialVersionUID = 850829564678694565L;

    /**
     * id
     */
    private String id;

    /**
     * 科目Id
     */
    private String subjectId;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 赛事Id
     */
    private String matchId;

    /**
     * 赛事名称
     */
    private String matchName;

    /**
     * 赛制类型（0-个人,1-团体）
     */
    private Byte type;

    /**
     * 页面展示参数ID
     */
    private String pageShow;

    /**
     * 页面展示参数名称
     */
    private String pageShowComment;

    /**
     * 温馨提示内容
     */
    private String tips;

    /**
     * 领取开关：1-开启，0-关闭
     */
    private Integer status;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 赛事科目报名字段
     */
    private List<SubjectSignField> subjectSignFields;

    /**
     * 赛事科目报名信息
     */
    private List<SignRecordFieldTable> SignRecordFieldTables;

    /**
     * 赛事项目物资清单
     */
    private List<MatchProduct> MatchProducts;


    public MatchProductReceiveSetVO() {
    }


    public MatchProductReceiveSetVO(String subjectId, String subjectName, String matchId, String matchName, Byte type, String pageShow, String pageShowComment, String tips, Integer status) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.matchId = matchId;
        this.matchName = matchName;
        this.type = type;
        this.pageShow = pageShow;
        this.pageShowComment = pageShowComment;
        this.tips = tips;
        this.status = status;
    }

    public MatchProductReceiveSetVO(String subjectId, String subjectName, String matchId, String matchName, Byte type, String pageShow, String pageShowComment, String tips, Integer status, List<SubjectSignField> subjectSignFields) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.matchId = matchId;
        this.matchName = matchName;
        this.type = type;
        this.pageShow = pageShow;
        this.pageShowComment = pageShowComment;
        this.tips = tips;
        this.status = status;
        this.subjectSignFields = subjectSignFields;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SubjectSignField> getSubjectSignFields() {
        return subjectSignFields;
    }

    public void setSubjectSignFields(List<SubjectSignField> subjectSignFields) {
        this.subjectSignFields = subjectSignFields;
    }

    public List<MatchProduct> getMatchProducts() {
        return MatchProducts;
    }

    public void setMatchProducts(List<MatchProduct> matchProducts) {
        MatchProducts = matchProducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SignRecordFieldTable> getSignRecordFieldTables() {
        return SignRecordFieldTables;
    }

    public void setSignRecordFieldTables(List<SignRecordFieldTable> signRecordFieldTables) {
        SignRecordFieldTables = signRecordFieldTables;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
