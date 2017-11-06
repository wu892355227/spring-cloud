package com.consumer.controller;

import com.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Value("${provide.providePath}")
//    private String providePath;

    @ResponseBody
    @RequestMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Integer id) {

        System.out.println("hahaha--------");


        return restTemplate.getForEntity("http://provide/findById/" + id, User.class);
    }



}
