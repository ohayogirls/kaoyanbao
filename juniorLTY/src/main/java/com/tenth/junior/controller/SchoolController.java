package com.tenth.junior.controller;

import com.tenth.junior.bean.School;
import com.tenth.junior.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/")
    public String index(Model model){
        List<School> schoolList = schoolService.findAllSchool();
        model.addAttribute("school",schoolList);
        return "school-table";
    }



}
