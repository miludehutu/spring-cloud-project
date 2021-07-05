package com.microservice.controller;

import com.microservice.entity.User;
import com.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private  UserService userService;
    @RequestMapping("getUser/{id}")
    public User GetUser(@PathVariable int id){

        return userService.sel_user_id(id);
    }
}
