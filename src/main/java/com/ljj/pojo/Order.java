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

    public void setDish_list(String dish_list) {
        this.dish_list = dish_list;
        String[] dishes = dish_list.split(",");
        total = 0;
        for (String dish : dishes) {
            String[] dishDetails = dish.split("/");
            double price = Double.parseDouble(dishDetails[1]);
            int quantity = Integer.parseInt(dishDetails[2]);
            total += price * quantity;
        }
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
