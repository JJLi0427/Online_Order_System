package com.ljj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class DishController {
    
    @RequestMapping()
    public String list(){
        return "index";
    }
}
