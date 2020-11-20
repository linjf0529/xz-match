package com.xz.match.entity.vo;


import com.xz.match.entity.*;

import java.util.List;

/**
 * 物资领取配置表VO
 *
 * @author gaorh
 * @create 2020-11-09
 */
public class MatchProductReceiveSetVO extends MatchProductReceiveSet {


    /**
     * 选手端地址
     */
    private String recordUrl;

    /**
     * 赛事科目报名字段
     */
    private List<SubjectSignField> subjectSignFields;

    /**
     * 赛事科目报名信息（废弃）
     */
    private List<SignRecordFieldTable> SignRecordFieldTables;

    /**
     * 选手报名信息
     */
    private SignRecord signRecord;

    /**
     * 赛事项目物资清单
     */
    private List<MatchProduct> MatchProducts;

    public List<SubjectSignField> getSubjectSignFields() {
        return subjectSignFields;
    }

    public void setSubjectSignFields(List<SubjectSignField> subjectSignFields) {
        this.subjectSignFields = subjectSignFields;
    }

    public List<SignRecordFieldTable> getSignRecordFieldTables() {
        return SignRecordFieldTables;
    }

    public void setSignRecordFieldTables(List<SignRecordFieldTable> signRecordFieldTables) {
        SignRecordFieldTables = signRecordFieldTables;
    }

    public SignRecord getSignRecord() {
        return signRecord;
    }

    public void setSignRecord(SignRecord signRecord) {
        this.signRecord = signRecord;
    }

    public List<MatchProduct> getMatchProducts() {
        return MatchProducts;
    }

    public void setMatchProducts(List<MatchProduct> matchProducts) {
        MatchProducts = matchProducts;
    }

    public String getRecordUrl() {
        return recordUrl;
    }

    public void setRecordUrl(String recordUrl) {
        this.recordUrl = recordUrl;
    }
}
