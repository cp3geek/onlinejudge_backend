package org.cp3geek.onlinejudge_backend.controller;

import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value="/userlogin")
    public User userLogin(String userName, String userPassword){
       User user = userService.userLogin(userName);
        System.out.println(user.getUserName());
        return user;
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
