package org.cp3geek.onlinejudge_backend.controller;

import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.service.UserService;
import org.cp3geek.onlinejudge_backend.util.ResponseResult;
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
        return null;
    }

    /**
     * 测试登陆
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


    @PostMapping("/login")
    public ResponseResult Login(User user){
        return userService.Login(user);
    }

}
