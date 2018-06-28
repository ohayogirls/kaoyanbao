package com.tenth.junior.controller;


import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.Material;
import com.tenth.junior.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    /**
     * 查看所有材料
     * @param model
     */
    @GetMapping
    public String index(Model model){
        List<Material> list=materialService.getAllMat();
        model.addAttribute("mat",list);
        return "material";
    }
    /**
     * 添加材料信息
     */
    @PostMapping("/add")
    public String input(Material material){
        materialService.addMaterial(material);
        return "redirect:/material";
    }

    /**
     * 显示添加页面
     */

    @GetMapping("/add")
    public String addPage(){
        return "add-mat";
    }

    /**
     * 修改界面
     * 显示修改界面updatematerial.html
     */
    @GetMapping("/update/{id}")
    public String updateMat(@PathVariable("id") Integer id, Model model){
        Optional<Material> material=materialService.findByID(id);
        model.addAttribute("mat",material);
        return "update-mat";
    }
    /**
     * 修改材料信息
     */
    @PostMapping("/update")
    public String updatematerial(Material material){
        materialService.addMaterial(material);
        return "redirect:/";
    }

    /**
     * 删除材料信息
     */
    @GetMapping("/delete/{id}")
    public String deleteMat(@PathVariable("id") Integer id){
        Optional<Material> material=materialService.findByID(id);
        materialService.deleteMaterial(material.get());
        return "redirect:/";
    }

}
