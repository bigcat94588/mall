package com.terry.springbootmall.service.impl;

import com.terry.springbootmall.dao.UserDao;
import com.terry.springbootmall.dto.UserRegisterRequest;
import com.terry.springbootmall.model.User;
import com.terry.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

}
