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
}
