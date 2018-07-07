package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer UserID;
    private String  UserName;
    private String  Password;
    private String  HeadPath;
    private String  Email;
    private Boolean IsAdministrator;
    private String  Phone;

    //private ArrayList<LoginTable> logintableArray;

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

    //public User(Integer UserID,String  UserName,String  Password) {
    //    UserID = UserID;
    //    UserName=UserName;
     //   Password = Password;
    //    logintableArray = new ArrayList<LoginTable>(3);
    //}
    public User(){
     //   logintableArray = new ArrayList<LoginTable>(3);
    }

    public User(User user) {
        UserID =user.getUserID();
        UserName = user.getUserName();
        Password = user.getPassword();
        HeadPath = user.getHeadPath();
        Email = user.getEmail();
        IsAdministrator = user.getAdministrator();
        Phone = user.getPhone();
    }
    // public ArrayList getLoginTables(){
   //     return logintableArray;
   // }

    //public void addLoginTableToUser(LoginTable aLoginTable){
    //    logintableArray.add(aLoginTable);
    //    aLoginTable.setUser(this);
    //}

}
