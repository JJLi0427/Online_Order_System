package com.ljj.controller;

import com.ljj.service.StaffService;
import com.ljj.pojo.Staff;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/staff")
public class StaffController {
    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private StaffService staffService;

    @RequestMapping("/allstaff")
    public String list(Model model){
        List<Staff> list = staffService.list();
        model.addAttribute("list", list);
        if (list != null){
            logger.info("Load all staff successfully");
        }
        return "allstaff";
    }

    @RequestMapping("/loginstaff")
    public String loginStaff(Staff inputstaff){ 
        String staff_name = inputstaff.getStaff_name();
        String password = inputstaff.getPassword();
        Staff staff = staffService.namegetStaff(staff_name);
        boolean fail = false;
        if (staff != null){
            logger.info("Get corresponding staff");
            String realpassword = staff.getPassword();
            if (password.equals(realpassword)){
                logger.info("Login successfully");
            } else {
                logger.info("Password is wrong");
                fail = true;
            }
        } else {
            logger.info("Staff does not exist");
            fail = true;
        }
        if (fail){
            return "redirect:/#stafflogin";
        }
        if (staff_name.equals("root")){
            return "redirect:/#manager";
        }
        return "normalstaff";
    }
}
