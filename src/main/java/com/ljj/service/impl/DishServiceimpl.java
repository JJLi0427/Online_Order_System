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

    public int addDish(Dish dish){
        int i = dishMapper.addDish(dish);
        return i;
    }

    public int deleteDish(int dish_id){
        int i = dishMapper.deleteDish(dish_id);
        return i;
    }

    public Dish idgetDish(int dish_id){
        Dish dish = dishMapper.idgetDish(dish_id);
        return dish;
    }

    public int updateDish(Dish dish){
        int i = dishMapper.updateDish(dish);
        return i;
    }
}
