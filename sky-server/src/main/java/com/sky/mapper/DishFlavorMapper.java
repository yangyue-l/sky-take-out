package com.sky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.entity.DishFlavor;

@Mapper
public interface DishFlavorMapper {

    
    void insertBatch(List<DishFlavor> flavors);

    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    /**
     * 根据菜品Id查询口味属性   
     * @param dishId
     * @return
     */
    @Select("select * from dish_flavor where dish_id = #{dish_id}")
    List<DishFlavor> getByDishId(Long dishId);



}
