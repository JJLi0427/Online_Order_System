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

    @RequestMapping("/updateuser")
    public String updateuser(User inputuser){
        long phone = inputuser.getPhone();
        int table = inputuser.getTable();
        int people = inputuser.getPeople();
        User user = userService.phonegetUser(phone);
        if (user != null){
            System.out.println("得到对应用户");
        } else {
            System.out.println("用户不存在");
            int i = userService.addUser(inputuser);
            if (i > 0){
                System.out.println("添加新用户成功");
            }
        }
        int i = userService.updateUser(user);
        if (i > 0){
            System.out.println("用户更新成功");
        }
        return "userorder";
    }
}
