package com.tenth.junior.controller;


import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.School;
import com.tenth.junior.service.ExperienceService;
import com.tenth.junior.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private SchoolService schoolService;

    /**
     * 查看所有的经验贴
     *此时应该需要返回到当前界面
     */
    @GetMapping
    public String index(Model model){
        List<Experience> list =experienceService.getAllExperience();
        model.addAttribute("exp",list);
        return "experience";
    }


    /**
     * 添加一条经验
     * 添加界面：experience/add
     */
    @PostMapping("/add")
    public String input(@Valid Experience experience, BindingResult bindingResult){
        Optional<School> school=schoolService.GetSchoolByID(experience.getSchoolID());
        experience.setSchool(school.get());
        experienceService.addExperience(experience);
        return "redirect:/experience";
    }
    /**
     * 显示添加界面
     * 展示所有的学校,,,！！！！！这里的schoolService没有写好，请在合并后修改
     */
    @GetMapping("/add")
    public String addPage(Model model){
        //model.addAttribute("allSchool",schoolService.getAll());//待修改
        return "add-exp";
    }

    /**
     * 删除经验功能
     *
     */
    @GetMapping("/delete/{id}")
    public String deleteExp(@PathVariable("id") Integer id){
        Optional<Experience> experience=experienceService.findByID(id);
        experienceService.deleteExperience(experience.get());
        return "redirect:/";
    }

    /**修改功能
     *
     */
    @GetMapping("/update/{id}")
    public String updataPage(@PathVariable("id") Integer id,Model model){
        model.addAttribute("exp",experienceService.findByID(id));
        return "update-exp";
    }
    @PostMapping("/update")
    public String updateData(Experience experience){
//        Optional<Experience> experience1 = experienceService.get (student.getGrade().getGID()); ;
//        student.setGrade(grade.get());
        //experience.setSchoolID();
         experienceService.addExperience(experience);
        return "redirect:/experience";
    }
    /**
     *
     */


}
