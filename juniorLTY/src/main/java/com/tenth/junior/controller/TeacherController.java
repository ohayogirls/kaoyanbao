package com.tenth.junior.controller;

import com.tenth.junior.bean.School;
import com.tenth.junior.bean.Teacher;
import com.tenth.junior.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public String index(Model model){
        List<Teacher> teacherList = teacherService.findAllTeacher();
        model.addAttribute("school",teacherList);
        return "redirect:/";
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
    @PostMapping("/update")
    public String updateSchool(Teacher teacher){
        teacherService.addATeacher(teacher);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteData(@RequestParam(value = "teacherid"/*,required = false,defaultValue = "0"*/)Integer teacherid ){
        teacherService.deleteTeacherByID(teacherid);
        return "redirect:/school";
    }
}
