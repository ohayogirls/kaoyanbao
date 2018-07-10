package com.tenth.junior.controller;

import com.tenth.junior.bean.Comment;
import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.Material;
import com.tenth.junior.bean.School;
import com.tenth.junior.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/show")
public class HomepageController {
    /**
     * @Author Liu Qi
     */
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

    /**
     *
     * @return 回到首页
     */
    @GetMapping
    public String gethomepage(){
        return "index";
    }

    /**
     *
     * @param province：省份
     * @param model：数据库中对应省份的学校数据
     * @return 院校咨询界面
     */
    @GetMapping("/yuanxiao/{province}")
    public String getschoolindex(@PathVariable("province") String province, Model model){
        List<School> schoolList= schoolService.findSchoolByProvince(schoolService.findAllSchool(),province);
        model.addAttribute("schIndex",schoolList);
        return "index-yuanxiao";
    }

    /**
     *
     * @param id：学校id
     * @param model： 数据库中对应id的学校数据
     * @return 学校信息的界面
     */
    @GetMapping("/school/{id}")
    public String schoolpage(@PathVariable("id") Integer id,Model model){
        model.addAttribute("school",schoolService.findSchoolByID(id).get());
        model.addAttribute("yearlydata",yearlyDataService.findBySchoolID(id));
        model.addAttribute("teacher",teacherService.findBySchoolID(id));
        model.addAttribute("experience",experienceService.findBySchoolID(id));
        return "school-info";

        //TODO:学校展示的页面
    }

    /**
     *
     * @param model：数据库中资料的数据
     * @return 资料分享界面
     */
    @GetMapping("/ziliao")
    public String getmaterial(Model model){
        List<Material> materialList = materialService.getAllMaterial();
        model.addAttribute("allMaterial",materialList);
        return "index-ziliao";
    }

    /**
     *
     * @param categoty：科目
     * @param type：类型
     * @param model：数据库中对应科目类型的资料数据
     * @return 资料分享界面
     */
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

    /**
     *
     * @param categoty：科目
     * @param model ：数据库中对应科目的资料数据
     * @return
     */
    @GetMapping("/ziliao/{category}")
    public  String materialpage2(@PathVariable("category") String categoty,Model model){
        List<Material> materialList1 = materialService.getAllMat();
        List<Material> materialList = materialService.findByCategory(materialList1,categoty);
        model.addAttribute("allMaterial",materialList);
        return "index-ziliao";
    }

    /**
     *
     * @param model：数据库中的所有经验
     * @return
     */
    @GetMapping("/jingyan")
    public String getexperience(Model model){
        List<Experience> experienceList=experienceService.getAllExperience();
        model.addAttribute("allExp",experienceList);
        return "index-jingyan";
    }

    /**
     *
     * @param type：类型
     * @param model：数据库中对应类型的经验
     * @return
     */
    @GetMapping("/jingyan/{type}")
    public String experience(@PathVariable("type")String type,Model model){
        List<Experience> experienceList =experienceService.findByType(type);
        model.addAttribute("allExp",experienceList);
        return "index-jingyan";
    }

    /**
     *
     * @param id：经验id
     * @param model：数据库中对应经验id的经验和评论
     * @return
     */
    @GetMapping("/jingyan/info/{id}")
    public String experienceinfo(@PathVariable("id")Integer id,Model model){
        Optional<Experience> experience =experienceService.findByID(id);
        List<Comment> commentList=commentService.getCommentByExp(experience.get());
        model.addAttribute("Exp",experience.get());
        model.addAttribute("comment",commentList);
        return "exp-info";
    }

    /**
     *
     * @param id：用户id
     * @param comment：评论
     * @param bindingResult：
     * @param model：数据库中对应用户id的评论
     * @return
     */
    @PostMapping("/jingyan/{id}/comment")

    public String addComment(@PathVariable("id")String id, @Valid Comment comment, BindingResult bindingResult, Model model){
        

        commentService.addComment(comment);
        return "redirect:/show/jingyan/info/"+id;
    }
    //
}
