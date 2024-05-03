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
}