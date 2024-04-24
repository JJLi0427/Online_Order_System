package com.ljj.mapper;

import java.util.List;
import com.ljj.pojo.Dish;
import org.springframework.stereotype.Repository;

@Repository
public interface DishMapper {
    List<Dish> LishDish();
    
    public Dish getDishById(int dish_id);
}