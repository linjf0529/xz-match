package com.xz.match.utils.enums;

public enum MatchScoreDefaultConfig {
    /**赛事名称*/
    MATCH_NAME(1L, "赛事名称"),

    /**项目名称*/
    SUBJECT_NAME(2L,"项目名称"),

    /**姓名*/
    NAME(3L,"姓名"),

    /**参赛号码*/
    MATCH_NO(4L,"参赛号码"),


    /**总成绩*/
    ACHIEVEMENT(5L,"成绩"),

    /**名次*/
    RANKING(6L,"名次");
    private final Long code;
    private final String text;
    private MatchScoreDefaultConfig(Long code, String text) {
        this.text = text;
        this.code = code;
    }
    public String getText() {
        return text;
    }

    public Long getCode() {
        return code;
    }

    public static String getText(Long code) {
        for (MatchScoreDefaultConfig e : MatchScoreDefaultConfig.values()) {
            if (e.getCode() == code) {
                return e.getText();
            }
        }
        return "";
    }
}
