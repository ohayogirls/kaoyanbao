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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/show")
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
    @GetMapping("/denglu")
    public String index(Model model) {
        //List<User> list = userService.getAllUser();
        //model.addAttribute("userdata", list);
        return "index-denglu";
    }
    @ResponseBody
    @PostMapping("/denglu")
    public Map<String,Object> Register(User user){
       Map<String,Object> map= new HashMap<String, Object>();
       String password1 = userService.findByName(user.getUserName()).getPassword();
       //flag1表示是否存在username
        // flag2表示password是否正确
       if(userService.findByName(user.getUserName()) != null){
           if( user.getPassword().equalsIgnoreCase(password1)){
               //登录成功，在LoginTable表中添加登录日志
               LoginTable loginTable = new LoginTable();
               loginTable.setUser(userService.findByName(user.getUserName()));
               loginTable.setLogID(loginTableService.getLogTanumber());
               loginTable.setTime(loginTableService.presentTime());
               loginTable.setIP(loginTableService.getIPAddr(request));
               loginTableService.addLoginTable(loginTable);
               map.put("flag1",1);
               map.put("flag2",1);
               map.put("user",userService.findByName(user.getUserName()));
               return map;
           }
           else {
               //密码错误
               map.put("flag1",1);
               map.put("flag2",0);
               return map;
           }
       }
        else {
           //username不存在
           map.put("flag1",0);
           return map;
       }
    }


    @GetMapping("/zhuce")
    public String addPage(Model model) {
        return "index-zhuce";
    }

    @PostMapping("/zhuce")
    public String getaddpage(User user) {
        if(userService.findByName(user.getUserName())!=null)
            return "redirect:/show/zhuce";
        else
            userService.addUser(user);
        return "index-denglu";

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


