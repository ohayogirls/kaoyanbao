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
    @Autowired
    private CommentService commentService;
    @GetMapping
    public String index(Model model){
        List<Comment> commentList =commentService.getAllComment();
        model.addAttribute("comment",commentList);
        return "comment";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        commentService.deletecomment(id);
        return "redirect:/comment";
    }

}
