package com.provide.controller;

import com.provide.entity.User;
import com.provide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/add")
    @ResponseBody
    public String add(){

        User user = new User();
        user.setUsername("wangwu");
        user.setPassword("1234");
        user.setAge(14);

        userService.addUser(user);

        return "success";
    }

    @ResponseBody
    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
      return  userService.findById(id);

    }

    @RequestMapping("/serviceInfo")
    @ResponseBody
    public ServiceInstance getService(){
        return discoveryClient.getLocalServiceInstance();
    }

}
