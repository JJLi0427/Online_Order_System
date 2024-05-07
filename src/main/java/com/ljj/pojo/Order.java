package com.ljj.pojo;

import java.text.DecimalFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private long order_id;
    private String prefer;
    private java.sql.Timestamp time;
    private String dish_list;
    private int user_id;
    private boolean complete;
    private double total;
    private long phone;
    private int table;

    public void setPrefer(String prefer) {
        this.prefer = prefer;
    }
    public void setTime(java.sql.Timestamp time) {
        this.time = time;
    }
    public void setDish_list(String dish_list) {
        this.dish_list = dish_list;
        setTotal(); 
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
        if (complete == true) {
            this.table = 0;
        }
    }
    public void setTotal() {
        String[] dishes = this.dish_list.split(",");
        double total = 0;
        for (String dish : dishes) {
            String[] dishDetails = dish.split("/");
            double price = Double.parseDouble(dishDetails[1]);
            int quantity = Integer.parseInt(dishDetails[2]);
            total += price * quantity;
        }
        this.total = total;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    public void setTable(int table) {
        this.table = table;
    }

    public long getOrder_id() {
        return order_id;
    }
    public String getPrefer() {
        return prefer;
    }
    public java.sql.Timestamp getTime() {
        return time;
    }
    public String getDish_list() {
        return dish_list;
    }
    public int getUser_id() {
        return user_id;
    }
    public boolean getComplete() {
        return complete;
    }
    public double getTotal() {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(total));
    }
    public long getPhone() {
        return phone;
    }
    public int getTable() {
        return table;
    }
}
