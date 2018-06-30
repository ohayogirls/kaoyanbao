package com.tenth.junior.repository;

import com.tenth.junior.bean.LoginTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LoginTableRepository extends JpaRepository<LoginTable,Integer>{
    @Query("select count(a.LogID) from LoginTable a")
    public Integer getLogTaNumber();


}
