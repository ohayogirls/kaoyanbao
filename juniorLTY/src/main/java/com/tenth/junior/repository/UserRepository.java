package com.tenth.junior.repository;

import com.tenth.junior.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>{


    @Query("select a from User a where a.UserName =?1 ")
    User getUserByName(String user_name);

    @Query("select count(a.UserID) from User a")
    public long getUserNumber();
}
