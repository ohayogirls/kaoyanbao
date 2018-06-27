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

    @GetMapping("/")
    public String index(Model model){
        List<YearlyData> yearlyDataList = yearlyDataService.findAllYearlyData();
        model.addAttribute("yearlydata",yearlyDataList);
        return "yearly-data";
    }

    @GetMapping("/add")
    public  String getaddpage(){
        return "addstu";
    }
    @PostMapping("/add")
    public String input(YearlyData yearlyData){
        yearlyDataService.addYearlyData(yearlyData);
        return "redirect:/";
    }

    @GetMapping("/delete/{pk}")
    public String deleteData(@PathVariable("pk") YearlyDataPK yearlyDatapk){
        yearlyDataService.deleteYearlyData(yearlyDatapk);
        return "redirect:/";
    }

    @GetMapping("/update/{pk}")
    public String updatepage(@PathVariable("pk") YearlyDataPK yearlyDataPK,Model model){
        model.addAttribute("yearlydata",yearlyDataService.findByID(yearlyDataPK).get());
        return "update-yearly-data";
    }

    @PostMapping("/update")
    public String updateData(YearlyData yearlyData){
        yearlyDataService.updateYearlyData(yearlyData);
        return "redirect:/";
    }

//    @PostMapping("/search")
//    public String searchData(@RequestParam(""),Model model){
//
//    }

}
