package com.tenth.junior.repository;

import com.tenth.junior.bean.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
