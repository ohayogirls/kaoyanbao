package com.tenth.junior.bean;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    private String  content;
    @ManyToOne
    private Experience experience;
    @OneToOne
    private  User user;

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
}
