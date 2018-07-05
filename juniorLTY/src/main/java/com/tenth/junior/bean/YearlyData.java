package com.tenth.junior.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class YearlyData {
    @EmbeddedId
    private YearlyDataPK pk=new YearlyDataPK();

    private Integer score;

    private String EnrollRate;

    public YearlyDataPK getPk() {
        return pk;
    }

    public void setPk(YearlyDataPK pk) {
        this.pk = pk;
    }

    @Transient
    public School getSchoolID(){
        return getPk().getSchool();
    }

    @Transient
    public Integer getYearID(){
        return getPk().getYear();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getEnrollRate() {
        return EnrollRate;
    }

    public void setEnrollRate(String enrollRate) {
        EnrollRate = enrollRate;
    }
}
