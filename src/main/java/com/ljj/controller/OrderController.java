package com.ljj.controller;

import com.ljj.service.OrderService;
import com.ljj.pojo.Order;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping("/allorder")
    public String list(Model model){
        List<Order> list = orderService.list();
        model.addAttribute("list", list);
        if (list != null){
            logger.info("Load all orders successfully");
        }
        return "allorder";
    }
}
