package com.tenth.junior.controller;

import com.tenth.junior.bean.User;
import com.tenth.junior.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/User")
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
        model.addAttribute("users", list);
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
    @PostMapping("/add")
    public String input(User user) {
        // Optional<Grade> grade = gradeService.getGradeByID(student.getGrade().getGID()); ;
        // student.setGrade(grade.get());
        userService.addUser(user);
        return "redirect:/";
    }

    /**
     * 显示添加页面
     *
     * @return
     */
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("allUser", userService.getAllUser());
        return "adduser";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Integer id, Model model) {
        Optional<User> user = userService.getUserByID(id);
        model.addAttribute("stu", user.get());
        model.addAttribute("allUser", userService.getAllUser());
        return "front-end-user";
    }

    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") User user) {
        userService.deleteUser(user);
        return "redirect:/";
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
    @PostMapping("/update")
    public String updateData(User user) {
        //Optional<Grade> grade = gradeService.getGradeByID(student.getGrade().getGID()); ;
        //student.setGrade(grade.get());
        userService.updateUser(user);
        return "redirect:/";
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


