package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

@Entity
public class LoginTable {
    /**访问记录的实体类
     * @author Qu Zhao
     */
    //定义私有属性
    @Id
    @GeneratedValue
    private Integer LogID;
    private String  IP;
    private Date    Time;
    @ManyToOne
    private User user;


    //构造函数
    public LoginTable(Integer LogID,String  IP,Date    Time,User aUser) {
        setLogID(LogID);
        setIP(IP);
        setTime(Time);
        setUser(aUser);
    }
    //无参构造函数
    public LoginTable(){

    }

    //getter and setter
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
