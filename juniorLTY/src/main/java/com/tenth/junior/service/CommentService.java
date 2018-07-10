package com.tenth.junior.service;

import com.tenth.junior.bean.Comment;
import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommentService {
    /**
     * 找到所有的评论数据
     * @return aimlist
     */
    List<Comment> getAllComment();

    /**
     * 通过经验找到对应的评论数据
     * @param experience 经验
     * @return aimlist
     */
    List<Comment> getCommentByExp(Experience experience);

    /**
     * 通过评论的id找到评论
     * @param id
     * @return 对应的评论
     */
    Optional<Comment> getCommentByID(Integer id);

    /**
     * 通过user找到评论
     * @param user
     * @return aimlist
     */
    List<Comment> getCommentByUser(User user);

    /**
     * 删除id对应的评论
     * @param id
     */
    void deletecomment(Integer id);

    /**
     * 增加一条评论
     * @param comment
     * @return 增加的评论
     */
    Comment addComment(Comment comment);

}
