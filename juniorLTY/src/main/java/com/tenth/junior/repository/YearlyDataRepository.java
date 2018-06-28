package com.tenth.junior.repository;

import com.tenth.junior.bean.YearlyData;
import com.tenth.junior.bean.YearlyDataPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface YearlyDataRepository extends JpaRepository<YearlyData,YearlyDataPK>{
//    @Query("select a from YearlyData a where a.schoolID like ?1")
//    public List<YearlyData> queryBySchoolID(Integer schoolid);
}
