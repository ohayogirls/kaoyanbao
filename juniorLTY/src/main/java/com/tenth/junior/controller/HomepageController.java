package com.tenth.junior.controller;

import com.tenth.junior.bean.Comment;
import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.Material;
import com.tenth.junior.bean.School;
import com.tenth.junior.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private CommentService commentService;
    @GetMapping
    public String gethomepage(){
        return "index";
    }

    @GetMapping("/yuanxiao/{province}")
    public String getschoolindex(@PathVariable("province") String province, Model model){
        List<School> schoolList= schoolService.findSchoolByProvince(schoolService.findAllSchool(),province);
        model.addAttribute("schIndex",schoolList);
        return "index-yuanxiao";
    }
    @GetMapping("/school/{id}")
    public String schoolpage(@PathVariable("id") Integer id,Model model){
        model.addAttribute("school",schoolService.findSchoolByID(id).get());
        model.addAttribute("yearlydata",yearlyDataService.findBySchoolID(id));
        model.addAttribute("teacher",teacherService.findBySchoolID(id));
        model.addAttribute("experience",experienceService.findBySchoolID(id));
        return "school-info";
        //TODO:学校展示的页面
    }
    //每个学校的报考经验
    @GetMapping("/school/{schoolid}/experience/{expid}")
    public String experiencepage(@PathVariable("schoolid") Integer schoolid,@PathVariable("expid")Integer expid, Model model){
        model.addAttribute("experience",experienceService.findByID(expid).get());
        model.addAttribute("school",schoolService.findSchoolByID(schoolid));
        return "exp-info";
    }
    @GetMapping("/ziliao")
    public String getmaterial(Model model){
        List<Material> materialList = materialService.getAllMaterial();
        model.addAttribute("allMaterial",materialList);
        return "index-ziliao";
    }
    @GetMapping("/ziliao/{category}/{type}")
    public  String materialpage1(@PathVariable("category") String categoty,@PathVariable("type")String type,Model model){
        List<Material> materialList1 ;
        List<Material> materialList2 ;
        List<Material> materialList ;
        materialList1 = materialService.getAllMat();
        materialList2 = materialService.findByCategory(materialList1,categoty);
        materialList = materialService.findByType(materialList2,type);
        model.addAttribute("allMaterial",materialList);
        return "index-ziliao";
    }
    @GetMapping("/ziliao/{category}")
    public  String materialpage2(@PathVariable("category") String categoty,Model model){
        List<Material> materialList1 = materialService.getAllMat();
        List<Material> materialList = materialService.findByCategory(materialList1,categoty);
        model.addAttribute("allMaterial",materialList);
        return "index-ziliao";
    }
    @GetMapping("/jingyan")
    public String getexperience(Model model){
        List<Experience> experienceList=experienceService.getAllExperience();
        model.addAttribute("allExp",experienceList);
        return "index-jingyan";
    }
    @GetMapping("/jingyan/{type}")
    public String experience(@PathVariable("type")String type,Model model){
        List<Experience> experienceList =experienceService.queryByExperienceType(type);
        model.addAttribute("allExp",experienceList);
        return "index-jingyan";
    }
    @GetMapping("/jingyan/info/{id}")
    public String experienceinfo(@PathVariable("id")Integer id,Model model){
        Optional<Experience> experience =experienceService.findByID(id);
        List<Comment> commentList=commentService.getCommentByExp(experience.get());
        model.addAttribute("Exp",experience.get());
        model.addAttribute("comment",commentList);
        return "exp-info";
    }
    @PostMapping("/jingyan/{id}/comment")
    public String addComment(@PathVariable("id")String id, Comment comment){
        commentService.addComment(comment);
        return "redirect:/jingyan/"+id;
    }
    //
}