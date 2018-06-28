package com.tenth.junior.repository;

import com.tenth.junior.bean.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience,Integer>{
    @Query("select a from Experience a where a.Type like ?1")
    List<Experience> queryByType(String type);
}
