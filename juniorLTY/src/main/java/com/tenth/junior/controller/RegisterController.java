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
    @GetMapping
    public String index(Model model) {
        //List<User> list = userService.getAllUser();
        //model.addAttribute("userdata", list);
        return "register";
    }

    /**
     * 用户注册信息
     * @param UserID
     * @param UserName
     * @param password
     * @param HeadPath
     * @param Email
     * @param IsAdministrator
     * @param Phone
     * @return
     */
    @GetMapping("/signIn")
    public String addPage(Model model) {
        return "sign-in";
    }

    @PostMapping("/signIn")
    public String getaddpage(User user) { ;
        userService.addUser(user);
        return "redirect:/";
    }

    /**
     * 登录
     * @param UserName
     * @param password
     * @return
     */
    @GetMapping("/register/{name}/{password}")
    public String Register(@PathVariable("name") String username,@PathVariable("password") String userpassword){

        if(userService.findByName(username).getPassword().equals(userpassword)){
            //登录成功，在LoginTable表中添加登录日志
            Integer userid = userService.findByName(username).getUserID();
            LoginTable loginTable = new LoginTable();
            loginTable.setUserID(userid);
            loginTable.setLogID(loginTableService.getLogTanumber());
            loginTable.setTime(loginTableService.presentTime());
            loginTable.setIP(loginTableService.getIPAddr(request));
            loginTableService.addLoginTable(loginTable);
            return "school";
        }
        else
            return "redirect:/";    //用户名或密码错误，重新输入数据
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


