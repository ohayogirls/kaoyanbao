package com.tenth.junior.repository;

import com.tenth.junior.bean.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>{
}
