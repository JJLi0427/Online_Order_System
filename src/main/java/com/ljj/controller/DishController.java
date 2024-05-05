package com.ljj.controller;

import com.ljj.service.DishService;
import com.ljj.pojo.Dish;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/dish")
public class DishController {
    private static final Logger logger = LoggerFactory.getLogger(DishController.class);

    @Autowired
    private DishService dishService;

    @RequestMapping("/alldish")
    public String list(Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("fromManage") == null) {
            return "redirect:/loginfail";
        }
        request.getSession().removeAttribute("fromManage");
        List<Dish> list = dishService.list();
        model.addAttribute("list", list);
        if (list != null){
            logger.info("Load all dishes successfully");
        }
        return "alldish";
    }

    @RequestMapping("/adddish")
    public String toAddDish(Dish dish){
        int i = dishService.addDish(dish);
        if (i > 0){
            logger.info("Insert dish successfully");
        }
        return "redirect:/dish/alldish";
    }

    @RequestMapping("/deletedish/{dish_id}")
    public String deleteDish(@PathVariable int dish_id){
        int i = dishService.deleteDish(dish_id);
        if (i > 0){
            logger.info("Delete dish successfully");
        }
        return "redirect:/dish/alldish";
    }

    @RequestMapping("/updatedish/{dish_id}")
    public String preupdateDish(@PathVariable int dish_id, Model model){
        Dish dish = dishService.idgetDish(dish_id);
        model.addAttribute("dish", dish);
        if (dish != null){
            logger.info("Get corresponding dish");
        }
        return "redirect:/dish/alldish";
    }

    @RequestMapping("/updatedish")
    public String updateDish(Dish dish){
        int i = dishService.updateDish(dish);
        if (i > 0){
            logger.info("Update dish successfully");
        }
        return "redirect:/dish/alldish";
    }

    @RequestMapping("/searchdish")
    public String searchDish(String dish_name, Model model){
        List<Dish> list = dishService.searchDish(dish_name);
        model.addAttribute("list", list);
        model.addAttribute("searchMode", true);
        if (list != null){
            logger.info("Search dish successfully");
        }
        return "redirect:/alldish";
    }
}
