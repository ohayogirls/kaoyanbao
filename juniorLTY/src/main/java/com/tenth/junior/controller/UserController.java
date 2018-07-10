package com.tenth.junior.controller;

import com.tenth.junior.bean.User;
import com.tenth.junior.bean.YearlyDataPK;
import com.tenth.junior.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * @author Qu Zhao
     */

    @Autowired
    private UserService userService;

    /**
     * 查看所有学生信息
     * @param model：数据库中所有的用户信息
     * @return
     */
    @GetMapping
    public String index(Model model) {
        List<User> list = userService.getAllUser();
        model.addAttribute("userdata", list);
        return "front-end-user";
    }

    /**
     * 添加用户信息功能
     *
     * @param UserID：用户id
     * @param UserName：用户姓名
     * @param password：密码
     * @param HeadPath：头像路径
     * @param Email：邮箱地址
     * @param IsAdministrator：是否为管理员
     * @param Phone：电话号码
     * @return
     */
    /**
     * 添加学生信息
     * @param model：数据库中的用户信息
     * @return
     */
    @GetMapping("/add")
    public String addPage(Model model) {
        return "add-fro";
    }

    /**
     * 添加学生信息
     * @param User：数据库中对应的用户
     * @return
     */
    @PostMapping("/add")
    public String getaddpage(User user) {
        userService.addUser(user);
        return "redirect:/user";
    }
    /**
     * 删除学生信息
     * @param User：数据库中对应的用户
     */
    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") User user) {
        userService.deleteUser(user);
        return "redirect:/user";
    }

    /**
     * 修改用户信息功能
     * @param UserID
     * @param UserName
     * @param password
     * @param HeadPath
     * @param Email
     * @param IsAdministrator
     * @param Phone
     * @return
     */
    /**
     * 修改学生信息
     * @param usereid：用户id
     * @param model：数据库中对应id的用户数据
     * @return
     */
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Integer userid, Model model) {

        User user = new User();
        user.setUserID(userid);
        model.addAttribute("userdata",userService.findByID(userid).get());
        return "update-fro";
    }
    /**
     * 修改学生信息
     * @param User：数据库中对应的用户
     * @return
     */
    @PostMapping("/update")
    public String updateData(User user) {
        userService.updateUser(user);
        return "redirect:/user";
    }

}


