package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Integer SchoolID;
    private String  SchoolName;
    private String  Area;
    private String  Province;
    private String  Outline;

    public String getCutTime() {
        return CutTime;
    }

    public void setCutTime(String cutTime) {
        CutTime = cutTime;
    }

    private String  CutTime;
    private String  CatalogLink;
    private String  ReferrenceBook;
    private Boolean Is985;
    private Boolean Is211;

    public School() {
    }

    public Integer getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(Integer schoolID) {
        SchoolID = schoolID;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getOutline() {
        return Outline;
    }

    public void setOutline(String outline) {
        Outline = outline;
    }

    public String getCatalogLink() {
        return CatalogLink;
    }

    public void setCatalogLink(String catalogLink) {
        CatalogLink = catalogLink;
    }

    public String getReferrenceBook() {
        return ReferrenceBook;
    }

    public void setReferrenceBook(String referrenceBook) {
        ReferrenceBook = referrenceBook;
    }

    public Boolean getIs985() {
        return Is985;
    }

    public void setIs985(Boolean is985) {
        Is985 = is985;
    }

    public Boolean getIs211() {
        return Is211;
    }

    public void setIs211(Boolean is211) {
        Is211 = is211;
    }
}
