package com.tenth.junior.repository;

import com.tenth.junior.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>{
//    @Query("select a from User a where a.username =?1 and password = ?2")
//    User getUserByNamAndPassword(String username, String password);

    @Query("select count(bean.id) from User bean")
    public long getUserNumber();
}
