package com.tenth.junior.service;

import com.tenth.junior.bean.Comment;
import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.User;
import com.tenth.junior.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public List<Comment> getCommentByExp(Experience experience) {

        List<Comment> list=new ArrayList<>();
        List<Comment> aimList=new ArrayList<>(commentRepository.findAll());
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getExperience().getExpID()==experience.getExpID()){
                list.add(aimList.get(i));
            }
        }
        return list;
    }

    @Override
    public Optional<Comment> getCommentByID(Integer id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> getCommentByUser(User user) {
        List<Comment> list=new ArrayList<>();
        List<Comment> aimList=new ArrayList<>(commentRepository.findAll());
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getUser().getUserID()==user.getUserID()){
                list.add(aimList.get(i));
            }
        }
        return list;
    }

    @Override
    public void deletecomment(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
}
