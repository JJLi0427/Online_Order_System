package com.ljj.controller;

import com.ljj.service.OrderService;
import com.ljj.pojo.Order;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/allorder")
    public String list(Model model){
        List<Order> list = orderService.list();
        model.addAttribute("list", list);
        if (list != null){
            System.out.println("所有订单加载成功");
        }
        return "allorder";
    }
}
