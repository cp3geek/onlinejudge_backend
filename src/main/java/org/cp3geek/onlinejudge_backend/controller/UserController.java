package org.cp3geek.onlinejudge_backend.controller;

import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value="/userlogin")
    public int userLogin(String userName,String userPassword){
       User user = userService.userLogin(userName,userPassword);
        System.out.println(user.getUserName());
        return 0;
    }

}
