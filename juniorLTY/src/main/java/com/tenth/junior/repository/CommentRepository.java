package com.tenth.junior.repository;

import com.tenth.junior.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
