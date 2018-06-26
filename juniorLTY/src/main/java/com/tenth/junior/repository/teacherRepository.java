package com.tenth.junior.repository;

import com.tenth.junior.bean.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teacherRepository extends JpaRepository<Teacher,Integer>{
}
