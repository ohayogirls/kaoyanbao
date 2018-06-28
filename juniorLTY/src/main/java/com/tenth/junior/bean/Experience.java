package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Experience {
    @Id
    @GeneratedValue
    private Integer ExpID;
    private String  Type;
    private String  Author;
    private Date    Time;
    private String  Text;
    //private String SchoolID;
    @ManyToOne
    private School school;

    public Experience() {
    }



    public Integer getExpID() {
        return ExpID;
    }

    public void setExpID(Integer expID) {
        ExpID = expID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Integer getSchoolID() {
        return school.getSchoolID();
    }

    public void setSchoolID(Integer schoolID) {
         school.setSchoolID(schoolID);
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
