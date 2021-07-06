package com.microservice.controller;

import com.microservice.entity.User;
import com.microservice.service.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/test")
public class UserController {
    private  static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private  UserService userService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("getUser/{id}")
    public User GetUser(@PathVariable int id){

        return userService.sel_user_id(id);
    }
    @GetMapping("/user/{id}")
    public User findById(@PathVariable int id){

        return this.restTemplate.getForObject("http://microservice-provider-user-ribbon/test/getUser/"+id,User.class);
    }
    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance=this.loadBalancerClient.choose("microservice-provider-user-ribbon");
        UserController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
