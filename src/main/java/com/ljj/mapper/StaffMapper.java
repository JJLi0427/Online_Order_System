package com.ljj.mapper;

import java.util.List;
import com.ljj.pojo.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffMapper {
    List<Staff>listStaff();

    Staff namegetStaff(String staff_name);

    Staff idgeStaff(int staff_id);

    int deleteStaff(int staff_id);

    int addStaff(Staff staff);

    int updateStaff(Staff staff);
}
