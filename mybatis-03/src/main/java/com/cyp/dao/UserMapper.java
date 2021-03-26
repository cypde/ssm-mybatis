package com.cyp.dao;

import com.cyp.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    User getUserById(int id);

    List<User> getUserByLimit(Map<String,Integer> map);

}