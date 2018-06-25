package com.tenth.junior.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class yearlyDataController {
    public String index(Model model){
        return "yearly-data";
    }
}
