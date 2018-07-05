package com.tenth.junior.bean;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class YearlyDataPK implements Serializable {
    private School school;
    private Integer Year;

    public YearlyDataPK() {
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Integer getYearID() {
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
        return Objects.equals(school, that.school) &&
                Objects.equals(Year, that.Year);
    }

    @Override
    public int hashCode() {

        return Objects.hash(school, Year);
    }
}
