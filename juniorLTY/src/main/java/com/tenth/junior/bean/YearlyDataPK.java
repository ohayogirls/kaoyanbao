package com.tenth.junior.bean;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class YearlyDataPK implements Serializable {
    private Integer SchoolID;
    private Integer YearID;

    public YearlyDataPK() {
    }

    public Integer getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(Integer schoolID) {
        SchoolID = schoolID;
    }

    public Integer getYearID() {
        return YearID;
    }

    public void setYearID(Integer yearID) {
        YearID = yearID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearlyDataPK that = (YearlyDataPK) o;
        return Objects.equals(SchoolID, that.SchoolID) &&
                Objects.equals(YearID, that.YearID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(SchoolID, YearID);
    }
}
