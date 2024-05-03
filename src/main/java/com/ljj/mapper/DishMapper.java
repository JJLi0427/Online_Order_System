package com.ljj.mapper;

import java.util.List;
import com.ljj.pojo.Dish;
import org.springframework.stereotype.Repository;

@Repository
public interface DishMapper {
    List<Dish>listDish();
    
    int addDish(Dish dish);
    
    int deleteDish(int dish_id);

    Dish idgetDish(int dish_id);

    int updateDish(Dish dish);
}