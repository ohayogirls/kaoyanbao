package com.tenth.junior.controller;

import com.tenth.junior.bean.User;
import com.tenth.junior.bean.LoginTable;
import com.tenth.junior.service.UserService;
import com.tenth.junior.service.LoginTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/logintable")
public class LoginTabbleController {
    /**
     * @author Qu Zhao
     */

    @Autowired
    private LoginTableService loginTableService;

    @Autowired
    private UserService userService;
    /**
     * 查看所有日志信息
     * @param model：数据库中所有日志信息
     * @return
     */
    @GetMapping
    public  String index(Model model){
        List<LoginTable> list = loginTableService.getAllLoginTable();
        model.addAttribute("logindata",list);
        return "login-table";
    }




}


