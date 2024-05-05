package com.ljj.controller;

import com.ljj.service.OrderService;
import com.ljj.pojo.Order;
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
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping("/allorder/{type}")
    public String list(@PathVariable String type, Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("fromManage") == null && request.getSession().getAttribute("loginStaff") == null){
            return "redirect:/loginfail";
        }
        request.getSession().removeAttribute("fromManage");
        request.getSession().removeAttribute("loginStaff");
        List<Order> list = orderService.list();
        model.addAttribute("list", list);
        if (list != null){
            logger.info("Load all orders successfully");
        }
        if (type.equals("staff")){
            model.addAttribute("type", "staff");
        } else {
            model.addAttribute("type", "manager");
        }
        logger.info("Staff type: " + type);
        return "allorder";
    }

    @RequestMapping("/completeorder/{order_id}/{type}")
    public String completeOrder(@PathVariable int order_id, @PathVariable String type){
        int i = orderService.completeOrder(order_id);
        if (i > 0){
            logger.info("Complete order successfully");
        }
        if (type.equals("staff")){
            return "redirect:/order/allorder/staff";
        } else {
            return "redirect:/order/allorder/manager";
        }
    }
}
