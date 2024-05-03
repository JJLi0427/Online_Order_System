package com.ljj.controller;

import com.ljj.service.UserService;
import com.ljj.pojo.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/alluser")
    public String list(Model model){
        List<User> list = userService.list();
        model.addAttribute("list", list);
        if (list != null){
            System.out.println("所有用户加载成功");
        }
        return "alluser";
    }
}
