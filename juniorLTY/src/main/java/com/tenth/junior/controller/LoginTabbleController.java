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
@RequestMapping("/LoginTable")
public class LoginTabbleController {

    @Autowired
    private LoginTableService loginTableService;

    @Autowired
    private UserService userService;
    /**
     * 查看所有日志信息
     * @param model
     * @return
     */
    @GetMapping
    public  String index(Model model){
        List<LoginTable> list = loginTableService.getAllLoginTable();
        model.addAttribute("logTas",list);
        return "login-table";
    }

    /**
     * 添加日志信息功能
     * @param LogID
     * @param IP
     * @param Time
     * @return
     */
    @PostMapping("/add")
    public  String input(LoginTable loginTable){
        Optional<User> user = userService.getUserByID(loginTable.getUser().getUserID()); ;
        loginTable.setUser(user.get());
        loginTableService.addLoginTable(loginTable);
        return "redirect:/";
    }

    /**
     * 显示添加页面
     * @return
     */
    @GetMapping("/add")
    public String addPage(Model model){
        model.addAttribute("allUser",userService.getAllUser());
        return "addLogTa";
    }

    //@GetMapping("/ks")
    //public String ks(){
    //   return "KSbaoM";
    // }



    //更新
   /* @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Integer id,Model model){
        Optional<Student> student = studentService.findByID(id);
        model.addAttribute("stu",student.get());
        model.addAttribute("allGrade",gradeService.getAllGrade());
        return "updatestu";
    }

    /**
     * 修改学生信息
     * @param stuID
     * @param name
     * @param password
     * @param phone
     * @return String

    @PostMapping("/update")
    public String updateData(Student student){
        Optional<Grade> grade = gradeService.getGradeByID(student.getGrade().getGID()); ;
        student.setGrade(grade.get());
        studentService.addStudent(student);
        return "redirect:/";
    }

    //查询
    @PostMapping("/abc")
    public String getStudentQuery(@RequestParam("name") String name,Model model){
        List<Student> studentList = studentService.queryByStuName("%"+name+"%");
        model.addAttribute(s:"stus",studentList);
        return "index";
    }
    */
}


