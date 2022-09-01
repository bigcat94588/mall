package com.terry.springbootmall.dao;

import com.terry.springbootmall.dto.UserRegisterRequest;
import com.terry.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);
    Integer createUser(UserRegisterRequest userRegisterRequest);


}
