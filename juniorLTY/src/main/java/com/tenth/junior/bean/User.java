package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;

@Entity
public class User {
    /**用户的实体类
     * @author Qu Zhao
     */
    //定义私有属性
    @Id
    @GeneratedValue
    private Integer UserID;
    private String  UserName;
    private String  Password;
    private String  HeadPath;
    private String  Email;
    private Boolean IsAdministrator;
    private String  Phone;

    //getter and setter
    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getHeadPath() {
        return HeadPath;
    }

    public void setHeadPath(String headPath) {
        HeadPath = headPath;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Boolean getAdministrator() {
        return IsAdministrator;
    }

    public void setAdministrator(Boolean administrator) {
        IsAdministrator = administrator;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    //无参构造函数
    public User(){
    }

    //构造函数
    public User(User user) {
        UserID =user.getUserID();
        UserName = user.getUserName();
        Password = user.getPassword();
        HeadPath = user.getHeadPath();
        Email = user.getEmail();
        IsAdministrator = user.getAdministrator();
        Phone = user.getPhone();
    }

}
