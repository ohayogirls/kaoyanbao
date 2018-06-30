package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

@Entity
public class LoginTable {
    @Id
    @GeneratedValue
    private Integer LogID;
    private String  IP;
    private Date    Time;

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginTable(Integer LogID,String  IP,Date    Time,User aUser) {
        setLogID(LogID);
        setIP(IP);
        setTime(Time);
        setUser(aUser);
    }

    public LoginTable(){

    }

    public Integer getLogID() {
        return LogID;
    }

    public void setLogID(Integer logID) {
        LogID = logID;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }




}
