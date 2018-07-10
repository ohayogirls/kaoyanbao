package com.tenth.junior.controller;

import com.tenth.junior.bean.Comment;
import com.tenth.junior.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    /**
     * @Author Liu Qi
     */
    @Autowired
    private CommentService commentService;

    /**
     * 评论的后台管理界面
     * @param model：从数据库中获得的评论数据
     * @return 通过重定向，刷新页面
     */
    @GetMapping
    public String index(Model model){
        List<Comment> commentList =commentService.getAllComment();
        model.addAttribute("comment",commentList);
        return "comment";
    }

    /**
     *删除id对应的评论
     * @param id：评论的id
     * @return 通过重定向，刷新页面
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        commentService.deletecomment(id);
        return "redirect:/comment";
    }

}
