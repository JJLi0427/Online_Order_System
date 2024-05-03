package com.ljj.service;

import com.ljj.pojo.Dish;
import java.util.List;

public interface DishService {
    List<Dish> list();

    int addDish(Dish dish);

    int deleteDish(int dish_id);

    Dish idgetDish(int dish_id);

    int updateDish(Dish dish);
}
