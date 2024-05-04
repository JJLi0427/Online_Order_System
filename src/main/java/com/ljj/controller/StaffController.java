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

    @RequestMapping("/loginstaff")
    public String loginStaff(Staff inputstaff){ 
        String staff_name = inputstaff.getStaff_name();
        String password = inputstaff.getPassword();
        Staff staff = staffService.namegetStaff(staff_name);
        boolean fail = false;
        if (staff != null){
            System.out.println("得到对应员工");
            String realpassword = staff.getPassword();
            if (password.equals(realpassword)){
                System.out.println("密码正确");
            } else {
                System.out.println("密码错误");
                fail = true;
            }
        } else {
            System.out.println("员工不存在");
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
