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

    @Autowired
    private UserService userService;

    /**
     * 查看所有学生信息
     *
     * @param model
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
     * @param UserID
     * @param UserName
     * @param password
     * @param HeadPath
     * @param Email
     * @param IsAdministrator
     * @param Phone
     * @return
     */
    @GetMapping("/add")
    public String addPage(Model model) {
        return "add-fro";
    }

    @PostMapping("/add")
    public String getaddpage(User user) {
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") User user) {
        userService.deleteUser(user);
        return "redirect:/user";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Integer userid, Model model) {

//        Optional<User> user = userService.getUserByID(id);
//        model.addAttribute("stu", user.get());
//        model.addAttribute("allUser", userService.getAllUser());
//        return "update-fro";
        User user = new User();
        user.setUserID(userid);
        model.addAttribute("userdata",userService.findByID(userid).get());
        return "update-fro";
    }


    /**
     * 修改用户信息功能
     *
     * @param UserID
     * @param UserName
     * @param password
     * @param HeadPath
     * @param Email
     * @param IsAdministrator
     * @param Phone
     * @return
     */
    @PostMapping("/update")
    public String updateData(User user) {
        userService.updateUser(user);
        return "redirect:/user";
    }



/*
    //查询
    @PostMapping("/abc")
    public String getStudentQuery(@RequestParam("name") String name,Model model){
        List<Student> studentList = studentService.queryByStuName("%"+name+"%");
        model.addAttribute(s:"stus",studentList);
        return "index";
    }
*/
}


