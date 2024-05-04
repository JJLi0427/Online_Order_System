package com.ljj.pojo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private long order_id;
    private String prefer;
    private Data time;
    private Map<String, Double> dish_list;
    private int user_id;
    private boolean complete;

    public long getOrder_id() {
        return order_id;
    }
    public String getPrefer() {
        return prefer;
    }
    public Data getTime() {
        return time;
    }
    public Map<String, Double> getDish_list() {
        return dish_list;
    }
    public int getUser_id() {
        return user_id;
    }
    public boolean getComplete() {
        return complete;
    }
}
