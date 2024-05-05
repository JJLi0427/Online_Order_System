package com.ljj.controller;

import com.ljj.service.UserService;
import com.ljj.pojo.User;
import java.util.List;
import com.ljj.service.DishService;
import com.ljj.pojo.Dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private DishService dishService;

    @RequestMapping("/alluser")
    public String list(Model model){
        List<User> list = userService.list();
        model.addAttribute("list", list);
        if (list != null){
            logger.info("Load all users successfully");
        }
        return "alluser";
    }

    @RequestMapping("/updateuser")
    public String updateuser(User inputuser, Model model){
        long phone = inputuser.getPhone();
        User user = userService.phonegetUser(phone);
        if (user != null){
            logger.info("Get corresponding user");
        } else {
            logger.info("User does not exist");
            int i = userService.addUser(inputuser);
            if (i > 0){
                logger.info("Insert user successfully");
            }
        }
        int i = userService.updateUser(user);
        if (i > 0){
            logger.info("Update user successfully");
        }

        List<Dish> list = dishService.list();
        model.addAttribute("list", list);
        if (list != null){
            logger.info("Load all dishes successfully");
        }
        return "userorder";
    }
}
