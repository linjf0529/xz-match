package com.xz.match.entity;

/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
public class ReserveInfo {
    private Long id;

    /**
    * 赛事ID
    */
    private Long matchId;

    /**
    * 赛事名称
    */
    private String matchName;

    /**
    * 项目ID
    */
    private Long subjectId;

    /**
    * 项目名称
    */
    private String subjectName;

    /**
    * 地址
    */
    private String address;

    /**
    * 经度
    */
    private String longitude;

    /**
    * 纬度
    */
    private String latitude;

    /**
    * 预约日期
    */
    private String reserveDate;

    /**
    * 创建时间
    */
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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }
}