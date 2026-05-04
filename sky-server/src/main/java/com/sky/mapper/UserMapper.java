package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.entity.User;

@Mapper
public interface UserMapper {


    @Select("select * from user where openid = #{openId}")
    User getByUserOpenid(String opeanid);

    
    void insert(User user);


    @Select("select * from user where id = #{userId}")
    User getById(Long userId);



    
}