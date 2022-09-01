package com.terry.springbootmall.service.impl;

import com.terry.springbootmall.dao.UserDao;
import com.terry.springbootmall.dto.UserLoginRequest;
import com.terry.springbootmall.dto.UserRegisterRequest;
import com.terry.springbootmall.model.User;
import com.terry.springbootmall.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override    //register表示不只是創建帳號，還有其他的實作(處理有關註冊相關的所有邏輯)
    public Integer register(UserRegisterRequest userRegisterRequest) {
        //檢查註冊的email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if (user!=null){
            log.warn("該email {} 已經被{}註冊",userRegisterRequest.getEmail(),"Judy");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        //創建帳號
        }
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        if(user==null){
            log.warn("該email {} 尚未註冊",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user.getPassword().equals(userLoginRequest.getPassword())){
            return user;
        }else {
            log.warn("email {} 的密碼部正確",userLoginRequest.getEmail()); //JAVA字串比較不能用==
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}
