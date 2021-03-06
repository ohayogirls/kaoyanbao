package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Experience {
    /**经验的实体类
     * @author Li Bo Han
     */
    //定义私有属性
    @Id
    @GeneratedValue
    private Integer ExpID;
    private String  Type;
    private String  Author;
    private String  Time;
    private String  Text;
    private String Title;
    @ManyToOne
    private School school;

    //无参构造方法
    public Experience() {
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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
    public void setTime(String time) {
        Time = time;
    }

    public String getTime() {
        return Time;
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
