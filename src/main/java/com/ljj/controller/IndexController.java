package com.ljj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String toindex() {
        logger.info("Redirect to index page");
        return "index";
    }

    @RequestMapping("/index")
    public String toindex2() {
        logger.info("Redirect to index page");
        return "index";
    }

    @RequestMapping("/#stafflogin")
    public String tostafflogin() {
        logger.info("Redirect to staff login page");
        return "redirect:/index/#stafflogin";
    }

    @RequestMapping("/#manager")
    public String tomanager() {
        logger.info("Redirect to manager page");
        return "redirect:/index/#manager";
    }
}