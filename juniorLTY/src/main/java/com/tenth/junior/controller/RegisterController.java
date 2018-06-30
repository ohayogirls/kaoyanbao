package com.tenth.junior.controller;

import com.tenth.junior.bean.User;
import com.tenth.junior.bean.LoginTable;
import com.tenth.junior.service.LoginTableService;
import com.tenth.junior.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginTableService loginTableService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 登录界面
     * @return
     */
    @GetMapping("/register")
    public String index(Model model) {
        //List<User> list = userService.getAllUser();
        //model.addAttribute("userdata", list);
        return "register";
    }

   @PostMapping("/register")
    public String Register(User user){

       String password1 = userService.findByName(user.getUserName()).getPassword();
       if(userService.findByName(user.getUserName()) != null){
           if( user.getPassword().equalsIgnoreCase(password1)){
               //登录成功，在LoginTable表中添加登录日志
               LoginTable loginTable = new LoginTable();
               loginTable.setUser(userService.findByName(user.getUserName()));
               loginTable.setLogID(loginTableService.getLogTanumber());
               loginTable.setTime(loginTableService.presentTime());
               loginTable.setIP(loginTableService.getIPAddr(request));

               loginTableService.addLoginTable(loginTable);
               return "redirect:/logintable";
           }
           else
               return "redirect:/register";
       }
        else
            return "redirect:/register";    //用户名或密码错误，重新输入数据
    }

    /**
     * 用户注册信息
     * @param UserName
     * @param password
     * @return
     */
    @GetMapping("/signIn")
    public String addPage(Model model) {
        return "sign-in";
    }

    @PostMapping("/signIn")
    public String getaddpage(User user) {
        if(userService.findByName(user.getUserName())!=null)
            return "redirect:/signIn";
        else
            userService.addUser(user);
        return "school";

    }




    // @GetMapping("/delete/{id}")
    // public String deleteData(@PathVariable("id") User user) {
    //     userService.deleteUser(user);
    //     return "redirect:/user";
    // }

    // @GetMapping("/update/{id}")
    // public String updatePage(@PathVariable("id") Integer userid, Model model) {
    //     User user = new User();
    //     user.setUserID(userid);
    //     model.addAttribute("userdata",userService.findByID(userid).get());
    //     return "update-fro";
    // }

/*
    //查询
    @PostMapping("/abc")
    public String getStudentQuery(@RequestParam("name") String name,Model model){
        List<Student> studentList = studentService.queryByStuName("%"+name+"%");
        model.addAttribute(s:"stus",studentList);
        return "index";
    }
*/
}


