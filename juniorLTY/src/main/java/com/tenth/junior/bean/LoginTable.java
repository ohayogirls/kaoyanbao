package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class LoginTable {
    @Id
    @GeneratedValue
    private Integer LogID;
    private String  IP;
    private Date    Time;

    @ManyToOne
    private User user;

    public LoginTable() {
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

    public Integer getUserID() {
        return user.getUserID();
    }

    public void setUserID(Integer userID) {
        user.setUserID(userID);
    }
}
