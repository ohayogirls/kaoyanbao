package com.tenth.junior.controller;

import com.tenth.junior.bean.YearlyData;
import com.tenth.junior.bean.YearlyDataPK;
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
    @Autowired
    private YearlyDataService yearlyDataService;

    @GetMapping
    public String index(Model model){
        List<YearlyData> yearlyDataList = yearlyDataService.findAllYearlyData();
        model.addAttribute("yearlydata",yearlyDataList);
        return "yearly-data";
    }

    @GetMapping("/add")
    public  String getaddpage(){
        return "add-yea";
    }
    @PostMapping("/add")
    public String input(YearlyData yearlyData){
        yearlyDataService.addYearlyData(yearlyData);
        return "redirect:/yearlydata";
    }

    @GetMapping("/delete/{school}/{year}")
    public String deleteData(@PathVariable("school") Integer schoolid,@PathVariable("year") Integer yearid){
        YearlyDataPK pk = new YearlyDataPK();
        pk.setSchoolID(schoolid);
        pk.setYearID(yearid);
        yearlyDataService.deleteYearlyData(pk);
        return "redirect:/yearlydata";
    }

    @GetMapping("/update/{school}/{year}")
    public String updatepage(@PathVariable("school") Integer schoolid,@PathVariable("year") Integer yearid,Model model){
        YearlyDataPK pk = new YearlyDataPK();
        pk.setSchoolID(schoolid);
        pk.setYearID(yearid);
        model.addAttribute("yearlydata",yearlyDataService.findByID(pk).get());
        return "update-yea";
    }

    @PostMapping("/update")
    public String updateData(YearlyData yearlyData){
        yearlyDataService.updateYearlyData(yearlyData);
        return "redirect:/yearlydata";
    }

//    @PostMapping("/search")
//    public String searchData(@RequestParam(""),Model model){
//
//    }

}
