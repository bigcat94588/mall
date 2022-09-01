package com.terry.springbootmall.service;

import com.terry.springbootmall.dto.UserLoginRequest;
import com.terry.springbootmall.dto.UserRegisterRequest;
import com.terry.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);
    User login(UserLoginRequest userLoginRequest);
}
