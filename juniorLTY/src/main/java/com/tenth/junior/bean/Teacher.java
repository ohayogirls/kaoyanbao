package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Teacher {
    /**老师的实体类
     * @author Xie Liang Cai
     */
    //定义私有属性
    @Id
    @GeneratedValue
    private Integer TeacherID;
    private String  Name;
    private String  Sex;
    private String  CV;
    private String  Research;
    private String  Email;
    private String  JobTitle;
    private String  Introduction;

    @ManyToOne
    private School school;

    //无参构造函数
    public Teacher() {
    }

    //getter and setter
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Integer getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(Integer teacherID) {
        TeacherID = teacherID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String getResearch() {
        return Research;
    }

    public void setResearch(String research) {
        Research = research;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public Integer getSchoolID() {
        return school.getSchoolID();
    }

    public void setSchoolID(Integer schoolID) {
        school.setSchoolID(schoolID);
    }
}
