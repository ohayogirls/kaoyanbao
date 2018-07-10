package com.tenth.junior.controller;

import com.tenth.junior.bean.School;
import com.tenth.junior.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/school")
public class SchoolController {
    /**
     * @author Xie Liang Cai
     */

    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public String index(Model model){
        List<School> schoolList = schoolService.findAllSchool();
        model.addAttribute("school",schoolList);
        return "school";
    }

    @GetMapping("/add")
    public  String getaddpage(){
        return "add-sch";
    }

    /**
     * 添加学校信息
     * @param school
     * @return
     */
    @PostMapping("/add")
    public String input(School school){
        schoolService.addASchool(school);
        return "redirect:/school";
    }

    /**
     * 更新school
     */

    @GetMapping("/update/{id}")
    public String updateSchool(@PathVariable("id")Integer id,Model model){
//        Optional<School> school=schoolService.findSchoolByID(id);
        //model.addAttribute("stu", school.get());
        model.addAttribute("school", schoolService.findSchoolByID(id).get());
        return "update-sch";
    }

    @PostMapping("/update")
    public String updateSchool(School school){
        schoolService.addASchool(school);
        return "redirect:/school";
    }

    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") School school) {
        schoolService.deleteSchool(school);
        return "redirect:/school";
    }

}
