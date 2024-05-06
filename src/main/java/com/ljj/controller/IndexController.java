package com.ljj.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String toindex(HttpServletRequest request) {
        logger.info("Redirect to index page");
        request.getSession().removeAttribute("loginStaff");
        request.getSession().removeAttribute("loginManage");
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("fromManage");
        request.getSession().removeAttribute("success");
        return "index";
    }

    @RequestMapping("/index")
    public String toindex2() {
        return "redirect:/";
    }

    @RequestMapping("/loginfail")
    public String tostafflogin() {
        logger.info("Redirect to staff login page");
        return "redirect:/index/#stafflogin";
    }

    @RequestMapping("/userfail")
    public String touserlogin() {
        logger.info("Redirect to user login page");
        return "redirect:/index/#userlogin";
    }

    @RequestMapping("/manage")
    public String tomanager(HttpServletRequest request) {
        if (request.getSession().getAttribute("loginManage") == null) {
            return "redirect:/loginfail";
        }
        request.getSession().setAttribute("fromManage", true);
        logger.info("Redirect to manage page");
        return "manage";
    }

    @RequestMapping("/userorder")
    public String touserorder(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("loginUser") == null && request.getSession().getAttribute("success") == null){
            return "redirect:/userfail";
        }
        if (request.getSession().getAttribute("success") != null){
            model.addAttribute("success", true);
            request.getSession().removeAttribute("success");
        }
        return "userorder";
    }
}