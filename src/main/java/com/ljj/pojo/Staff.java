package com.ljj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Staff {
    private int staff_id;
    private String staff_name;
    private long order_id;
    private String password;

    public int getStaff_id() {
        return staff_id;
    }
    public String getStaff_name() {
        return staff_name;
    }
    public long getOrder_id() {
        return order_id;
    }
    public String getPassword() {
        return password;
    }
}
