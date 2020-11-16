package com.xz.match.utils;

/**
 * @author chenwf
 * @date 2020/11/16
 */
public class ResponseResult {
    private String success;
    private Integer code;
    private Long timestamp;
    private String message;
    private Object data;

    public Object getData() {
        return this.data;
    }

    public ResponseResult setData(Object data) {
        this.data = data;
        return this;
    }

    public String getSuccess() {
        return success;
    }

    public ResponseResult setSuccess(String success) {
        this.success = success;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResponseResult ok() {
        return (new ResponseResult()).setSuccess("T");
    }

    public static ResponseResult fail(String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess("F");
        responseResult.setCode(400);
        responseResult.setMessage(message);
        responseResult.setTimestamp(System.currentTimeMillis());
        return responseResult;
    }

    public static ResponseResult fail(Integer code,String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess("F");
        responseResult.setCode(code);
        responseResult.setMessage(message);
        responseResult.setTimestamp(System.currentTimeMillis());
        return responseResult;
    }
}
