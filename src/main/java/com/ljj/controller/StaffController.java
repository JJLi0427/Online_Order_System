package com.ljj.controller;

import com.ljj.service.StaffService;
import com.ljj.pojo.Staff;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String list(Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("fromManage") == null) {
            return "redirect:/loginfail";
        }
        request.getSession().removeAttribute("fromManage");
        List<Staff> list = staffService.list();
        model.addAttribute("list", list);
        if (list != null){
            logger.info("Load all staff successfully");
        }
        return "allstaff";
    }

    @RequestMapping("/loginstaff")
    public String loginStaff(Staff inputstaff, HttpServletRequest request){ 
        String staff_name = inputstaff.getStaff_name();
        String password = inputstaff.getPassword();
        Staff staff = staffService.namegetStaff(staff_name);
        boolean fail = false;
        if (staff != null){
            logger.info("Get corresponding staff");
            String realpassword = staff.getPassword();
            if (password.equals(realpassword)){
                logger.info("Login successfully");
            } 
            else {
                logger.info("Password is wrong");
                fail = true;
            }
        } 
        else {
            logger.info("Staff does not exist");
            fail = true;
        }
        if (fail){
            logger.info("Login failed, redirect to staff login page");
            return "redirect:/loginfail";
        }
        if (staff_name.equals("root")){
            request.getSession().setAttribute("loginManage", true);
            logger.info("Login as manager, redirect to manager page");
            return "redirect:/manage";
        }
        request.getSession().setAttribute("loginStaff", true);
        return "redirect:/order/allorder/staff";
    }

    @RequestMapping("/deletdstaff/{staff_id}")
    public String deleteStaff(@PathVariable int staff_id){
        Staff staff = staffService.idgeStaff(staff_id);
        String staff_name = staff.getStaff_name();
        if (staff_name == "root"){
            logger.info("Cannot delete root staff");
        } 
        else {
            int i = staffService.deleteStaff(staff_id);
            if (i > 0){
                logger.info("Delete staff successfully");
            }
        }
        return "redirect:/staff/allstaff";
    }

    @RequestMapping("/addstaff")
    public String toAddStaff(Staff staff){
        int i = staffService.addStaff(staff);
        if (i > 0){
            logger.info("Insert staff successfully");
        }
        return "redirect:/staff/allstaff";
    }

    @RequestMapping("/updatestaff/{staff_id}")
    public String updateStaff(@PathVariable int staff_id, Staff staff){
        staff.setStaff_id(staff_id);
        int i = staffService.updateStaff(staff);
        if (i > 0){
            logger.info("Update staff successfully");
        }
        return "redirect:/staff/allstaff";
    }
}
