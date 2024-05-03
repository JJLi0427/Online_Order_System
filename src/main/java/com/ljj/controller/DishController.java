package com.ljj.controller;

import com.ljj.service.DishService;
import com.ljj.pojo.Dish;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/adddish")
    public String toAddDish(Dish dish){
        int i = dishService.addDish(dish);
        if (i > 0){
            System.out.println("添加成功");
        }
        return "redirect:/dish/alldish";
    }

    @RequestMapping("/deletedish/{dish_id}")
    public String deleteDish(@PathVariable int dish_id){
        int i = dishService.deleteDish(dish_id);
        if (i > 0){
            System.out.println("删除成功");
        }
        return "redirect:/dish/alldish";
    }

    @RequestMapping("/updatedish/{dish_id}")
    public String preupdateDish(@PathVariable int dish_id, Model model){
        Dish dish = dishService.idgetDish(dish_id);
        model.addAttribute("dish", dish);
        return "updatedish";
    }

    @RequestMapping("/updatedish")
    public String updateDish(Dish dish){
        int i = dishService.updateDish(dish);
        if (i > 0){
            System.out.println("修改成功");
        }
        return "redirect:/dish/alldish";
    }
}
