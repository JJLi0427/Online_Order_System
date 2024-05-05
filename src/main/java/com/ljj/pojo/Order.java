package com.ljj.pojo;

import java.text.DecimalFormat;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
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

    public String formatDishList(String dish_list) {
        String result = dish_list.replaceAll("\"\\w+\"\\s*:\\s*\\d+(\\.\\d+)?,", "");
        result = result.replaceAll("[{}\"]", "");
        result = result.replaceAll(", ", ",");
        return result;
    }

    public void setDish_list(String dish_list) {
        this.dish_list = dish_list;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Double> dishes = mapper.readValue(dish_list, new TypeReference<Map<String, Double>>(){});
            for (Double price : dishes.values()) {
                total += price;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dish_list = formatDishList(dish_list);
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
