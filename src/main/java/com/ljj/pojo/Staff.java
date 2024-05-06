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

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }
    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }
    public void setPassword(String password) {
        this.password = password;
    }

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
