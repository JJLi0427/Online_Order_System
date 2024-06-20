package com.ljj.service.impl;

import com.ljj.service.OrderService;
import com.ljj.mapper.OrderMapper;
import com.ljj.pojo.Order;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceimpl implements OrderService{
    @Autowired
    private OrderMapper OrderMapper;

    public List<Order> list(){
        List<Order> list = OrderMapper.listOrder();
        return list;
    }

    public Order idgetOrder(int order_id){
        Order order = OrderMapper.idgetOrder(order_id);
        return order;
    }

    public int completeOrder(int order_id){
        int i = OrderMapper.completeOrder(order_id);
        return i;
    }

    public int addOrder(Order order){
        int i = OrderMapper.addOrder(order);
        return i;
    }

    public List<Order> usergetOrder(int user_id){
        List<Order> list = OrderMapper.usergetOrder(user_id);
        return list;
    }

    public int deleteold(){
        int i = OrderMapper.deleteold();
        return i;
    }
}