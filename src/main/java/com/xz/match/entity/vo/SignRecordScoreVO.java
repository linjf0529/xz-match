package com.xz.match.entity.vo;

import com.xz.match.entity.SignRecord;

/**
 * @program: xz-match
 * @description:
 * @author: Linjf
 * @create date: 2020-11-17 16:23
 **/
public class SignRecordScoreVO extends SignRecord {
    /**
     * 成绩
     */
    private String achievement;
    /**
     * 名次
     */
    private String ranking;

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
