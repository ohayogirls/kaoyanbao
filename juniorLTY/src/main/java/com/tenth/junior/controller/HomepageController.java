package com.tenth.junior.controller;

import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.Material;
import com.tenth.junior.bean.School;
import com.tenth.junior.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/show")
public class HomepageController {
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private YearlyDataService yearlyDataService;
    @GetMapping
    public String gethomepage(){
        return "homepage";
    }

    @GetMapping("/yuanxiao/{province}")
    public String getschoolindex(@PathVariable("province") String province, Model model){
        List<School> schoolList= schoolService.findSchoolByProvince(schoolService.findAllSchool(),province);
        model.addAttribute("schIndex",schoolList);
        return "index-yuanxiao";
    }
    @GetMapping("/school/{id}")
    public String schoolpage(@PathVariable("id") Integer id,Model model){
        model.addAttribute("school",schoolService.findSchoolByID(id));
        model.addAttribute("yearlydata",yearlyDataService.findBySchoolID(id));
        model.addAttribute("teacher",teacherService.findTeacherBySchool(teacherService.findAllTeacher(),schoolService.findSchoolByID(id).get().getSchoolName()));
        model.addAttribute("experience",experienceService.findBySchoolID(id));
        return "school-info";
        //TODO:学校展示的页面

    }
    @GetMapping("/ziliao")
    public String getmaterial(Model model){
        List<Material> materialList = materialService.getAllMaterial();
        model.addAttribute("allMateria",materialList);
        return "index-ziliao";
    }
    @GetMapping("/jingyan")
    public String getexperience(Model model){
        List<Experience> experienceList=experienceService.getAllExperience();
        model.addAttribute("allExp",experienceList);
        return "index-exp";
    }

}
