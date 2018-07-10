package com.tenth.junior.controller;

import com.tenth.junior.bean.School;
import com.tenth.junior.bean.YearlyData;
import com.tenth.junior.bean.YearlyDataPK;
import com.tenth.junior.service.SchoolService;
import com.tenth.junior.service.YearlyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/yearlydata")
public class YearlyDataController {
    /**
     * @Author Liu Qi
     */
    @Autowired
    private YearlyDataService yearlyDataService;
    @Autowired
    private SchoolService schoolService;
    @GetMapping
    public String index(Model model){
        List<YearlyData> yearlyDataList = yearlyDataService.findAllYearlyData();
        List<School> schoolList = schoolService.findAllSchool();
        model.addAttribute("allSchool",schoolList);
        model.addAttribute("yearlydata",yearlyDataList);
        return "yearly-data";
    }

    /**
     * 增加历年数据的时候显示学校下拉框
     * @param model
     * @return
     */
    @GetMapping("/add")
    public  String getaddpage(Model model) {
        List<School> schoolList = schoolService.findAllSchool();
        model.addAttribute("allSchool",schoolList);
        return "add-yea";

    }

    /**
     * 增加
     * @param yearlyData
     * @return
     */
    @PostMapping("/add")
    public String input(YearlyData yearlyData){
        yearlyDataService.addYearlyData(yearlyData);
        return "redirect:/yearlydata";
    }

    /**
     * 删除
     * @param schoolid
     * @param year
     * @return
     */
    @GetMapping("/delete/{school}/{year}")
    public String deleteData(@PathVariable("school") Integer schoolid,@PathVariable("year") Integer year){
        YearlyDataPK pk = new YearlyDataPK();
        pk.setSchoolid(schoolid);
        pk.setYear(year);
        yearlyDataService.deleteYearlyData(pk);
        return "redirect:/yearlydata";
    }

    /**
     * 修改
     * @param schoolid
     * @param year
     * @param model
     * @return
     */
    @GetMapping("/update/{school}/{year}")
    public String updatepage(@PathVariable("school") Integer schoolid,@PathVariable("year") Integer year,Model model){
        YearlyDataPK pk = new YearlyDataPK();
        pk.setSchoolid(schoolid);
        pk.setYear(year);
        model.addAttribute("yearlydata",yearlyDataService.findByID(pk).get());
        List<School> schoolList = schoolService.findAllSchool();
        model.addAttribute("allSchool",schoolList);
        return "update-yea";
    }

    /**
     * 修改
     * @param yearlyData
     * @return
     */
    @PostMapping("/update")
    public String updateData(YearlyData yearlyData){
        yearlyDataService.updateYearlyData(yearlyData);
        return "redirect:/yearlydata";
    }



}
