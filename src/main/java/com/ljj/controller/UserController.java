package com.ljj.controller;

import com.ljj.service.UserService;
import com.ljj.pojo.User;
import java.util.List;
import com.ljj.service.DishService;
import com.ljj.pojo.Dish;

import javax.servlet.http.HttpServletRequest;

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
    public String list(Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("fromManage") == null) {
            return "redirect:/loginfail";
        }
        request.getSession().removeAttribute("fromManage");
        List<User> list = userService.list();
        model.addAttribute("list", list);
        if (list != null){
            logger.info("Load all users successfully");
        }
        return "alluser";
    }

    @RequestMapping("/updateuser")
    public String updateuser(User inputuser, Model model, HttpServletRequest request){
        long phone = inputuser.getPhone();
        User user = userService.phonegetUser(phone);
        int user_id = 0;
        if (user != null){
            user_id = user.getUser_id();
            logger.info("Get corresponding user");
        } else {
            logger.info("User does not exist");
            int i = userService.addUser(inputuser);
            if (i > 0){
                logger.info("Insert user successfully");
            }
            user_id = userService.phonegetUser(phone).getUser_id();
        }
        int i = userService.updateUser(user);
        if (i > 0){
            logger.info("Update user successfully");
        }

        List<Dish> list = dishService.list();
        model.addAttribute("list", list);
        model.addAttribute("user_id", user_id);
        if (list != null){
            logger.info("Load all dishes successfully");
        }
        request.getSession().setAttribute("loginUser", true);
        return "userorder";
    }

    @RequestMapping("/back")
    public String back(HttpServletRequest request){
        request.getSession().removeAttribute("loginUser");
        return "redirect:/userorder";
    }
}
