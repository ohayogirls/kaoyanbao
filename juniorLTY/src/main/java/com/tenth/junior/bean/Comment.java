package com.tenth.junior.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class Comment {
    /**评论的实体类
     * @author Liu Qi
     * @version 1.0
     */
    //定义私有属性
    @Id
    @GeneratedValue
    private Integer id;
    private String  content;
    private Timestamp time;
    @ManyToOne
    private Experience experience;
    @OneToOne
    private  User user;

    //无参构造方法
    public Comment(){

    }

    //getter和setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
