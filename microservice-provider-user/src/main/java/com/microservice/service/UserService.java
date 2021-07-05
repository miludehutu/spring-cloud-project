package com.microservice.service;

import com.microservice.entity.User;
import com.microservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User sel_user_id(int id){
        return  userMapper.Sel_user_id(id);
    }
}
