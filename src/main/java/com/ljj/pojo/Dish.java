package com.ljj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dish {
    private int dish_id;
    private String dish_name;
    private double price;

    public int getDish_id() {
        return dish_id;
    }
    public String getDish_name() {
        return dish_name;
    }
    public double getPrice() {
        return price;
    }
}
