package com.cyp.dao;

import com.cyp.pojo.User;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserLike(String value);


    List<User> selectUser();

    User getUserById(int id);

    User getUserById2(Map<String,Object> map);

    User addUser2(Map<String,Object> map);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}