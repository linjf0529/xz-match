package com.xz.match.entity.vo;

/**
 * @author chenwf
 * @date 2020/11/17
 */
public class LoginVo {
    private String phone;  //手机号码
    private String certificateNo; //身份证号码
    private String passWord;  //密码
    private String verifiyCode; //验证码
    private Integer type; //登录类型 1系统物资发放人员 2报名选手

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getVerifiyCode() {
        return verifiyCode;
    }

    public void setVerifiyCode(String verifiyCode) {
        this.verifiyCode = verifiyCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
