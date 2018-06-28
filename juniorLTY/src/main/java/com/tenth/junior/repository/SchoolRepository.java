package com.tenth.junior.repository;

import com.tenth.junior.bean.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School,Integer> {

    @Query(value = "select * from School where schoolName=?1",nativeQuery = true)
    List<School> queryBySchoolName(@Param("SchoolName")String name);

}
