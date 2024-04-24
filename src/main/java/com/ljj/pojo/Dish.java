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
}
