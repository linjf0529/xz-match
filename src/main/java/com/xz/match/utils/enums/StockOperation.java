package com.xz.match.utils.enums;

/**
 *  操作，1-减去库存，2-加库存
 * @Author gaorh
 * @Date 2020/11/13 9:15
 * @Param  * @param null
 **/

public enum StockOperation {

    /**
     * 加库存
     */
    ADD ("加库存", "2"),
    /**
     * 减库存
     */
    MINUS ("减库存", "1"),;

    private final String text;
    private final String code;

    StockOperation(String text, String code) {
        this.text = text;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public String getCode() {
        return code;
    }

}
