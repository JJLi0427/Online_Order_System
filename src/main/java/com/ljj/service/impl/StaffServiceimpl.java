package com.ljj.service.impl;

import com.ljj.service.StaffService;
import com.ljj.mapper.StaffMapper;
import com.ljj.pojo.Staff;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceimpl implements StaffService{
    @Autowired
    private StaffMapper StaffMapper;

    public List<Staff> list(){
        List<Staff> list = StaffMapper.listStaff();
        return list;
    }

    public Staff namegetStaff(String staff_name){
        Staff staff = StaffMapper.namegetStaff(staff_name);
        return staff;
    }
}