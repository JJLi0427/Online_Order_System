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

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }
    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

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
