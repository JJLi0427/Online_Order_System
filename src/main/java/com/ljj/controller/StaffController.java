package com.ljj.controller;

import com.ljj.service.StaffService;
import com.ljj.pojo.Staff;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @RequestMapping("/allstaff")
    public String list(Model model){
        List<Staff> list = staffService.list();
        model.addAttribute("list", list);
        if (list != null){
            System.out.println("所有员工加载成功");
        }
        return "allstaff";
    }
}
