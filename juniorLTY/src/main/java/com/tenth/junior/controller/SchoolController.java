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
     * @param school
     * @return
     */
    @PostMapping("/update")
    public String updateSchool(School school){
        schoolService.addASchool(school);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteData(@RequestParam(value = "schoolid"/*,required = false,defaultValue = "0"*/)Integer schoolid ){
        schoolService.deleteSchoolByID(schoolid);
        return "redirect:/school";
    }

}
