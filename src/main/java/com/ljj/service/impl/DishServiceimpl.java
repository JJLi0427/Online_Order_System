package com.ljj.service.impl;

import com.ljj.service.DishService;
import com.ljj.mapper.DishMapper;
import com.ljj.pojo.Dish;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServiceimpl implements DishService{
    @Autowired
    private DishMapper dishMapper;

    public List<Dish> list(){
        List<Dish> list = dishMapper.listDish();
        return list;
    }
}
