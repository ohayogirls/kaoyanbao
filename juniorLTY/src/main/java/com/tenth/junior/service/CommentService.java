package com.tenth.junior.service;

import com.tenth.junior.bean.Comment;
import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommentService {
    List<Comment> getAllComment();
    List<Comment> getCommentByExp(Experience experience);
    Optional<Comment> getCommentByID(Integer id);
    List<Comment> getCommentByUser(User user);
    void deletecomment(Integer id);

}
