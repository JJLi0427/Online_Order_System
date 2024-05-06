package com.ljj.service;

import com.ljj.pojo.Order;
import java.util.List;

public interface OrderService {
    List<Order> list();

    Order idgetOrder(int order_id);

    int completeOrder(int order_id);

    int addOrder(Order order);

    List<Order> usergetOrder(int user_id);
}