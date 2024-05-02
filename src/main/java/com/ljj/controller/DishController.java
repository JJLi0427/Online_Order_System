package com.ljj.controller;

import com.ljj.service.DishService;
import com.ljj.pojo.Dish;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @RequestMapping("/alldish")
    public String list(Model model){
        List<Dish> list = dishService.list();
        model.addAttribute("list", list);
        return "alldish";
    }
}
