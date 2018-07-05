package com.tenth.junior.bean;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class YearlyDataPK implements Serializable {
    private Integer schoolid;
    private Integer Year;

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public YearlyDataPK() {
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearlyDataPK that = (YearlyDataPK) o;
        return
                Objects.equals(Year, that.Year)&&
                Objects.equals(schoolid,that.schoolid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Year,schoolid);
    }
}
