package com.tenth.junior.bean;

import javax.persistence.*;

@Entity
public class YearlyData {
    /**历年数据的实体类
     * @author Liu Qi
     */
    //定义私有属性
    @EmbeddedId
    private YearlyDataPK pk =new YearlyDataPK();

    private Integer score;

    private String EnrollRate;

    private String schoolname;

    //无参构造函数
    public YearlyData(){}

    //getter and setter
    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public YearlyDataPK getPk() {
        return pk;
    }

    public void setPk(YearlyDataPK pk) {
        this.pk = pk;
    }

    @Transient
    public Integer getYear(){
        return getPk().getYear();
    }

    @Transient
    public Integer getSchoolID() {return getPk().getSchoolid();}

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
