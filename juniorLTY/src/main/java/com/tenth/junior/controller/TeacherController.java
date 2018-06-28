package com.tenth.junior.controller;

import com.tenth.junior.bean.Teacher;
import com.tenth.junior.bean.User;
import com.tenth.junior.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public String index(Model model){
        List<Teacher> teacherList = teacherService.findAllTeacher();
        model.addAttribute("teacher",teacherList);
        return "teacher";
    }

    @GetMapping("/add")
    public  String getaddpage(){
        return "add-tea";
    }

    /**
     * 添加学校信息
     * @return
     */
    @PostMapping("/add")
    public String input(Teacher teacher){
        teacherService.addATeacher(teacher);
        return "redirect:/teacher";
    }

    /**
     * 更新
     */

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Integer id, Model model) {
        Optional<Teacher> teacher = teacherService.findTeacherByID(id);
        model.addAttribute("stu", teacher.get());
        model.addAttribute("allTeacher", teacherService.findAllTeacher());
        return "update-tea";
    }

    @PostMapping("/update")
    public String updateSchool(Teacher teacher){
        teacherService.addATeacher(teacher);
        return "redirect:/";
    }

    /**
     * 删除
     */

    @GetMapping(value = "/delete/{id}")
    public String deleteData(@PathVariable("id")Teacher teacher ){
        teacherService.deleteTeacher(teacher);
        return "redirect:/teacher";
    }
}
