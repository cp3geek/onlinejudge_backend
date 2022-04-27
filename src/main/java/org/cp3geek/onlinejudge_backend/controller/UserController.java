package org.cp3geek.onlinejudge_backend.controller;

import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.service.UserService;
import org.cp3geek.onlinejudge_backend.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    //@PreAuthorize("hasAuthority('test')")
    @PostMapping("/login")
    public ResponseResult Login(User user){
        return userService.Login(user);
    }

    @RequestMapping("/logout")
    public ResponseResult logout(){
        return userService.logout();
    }

}
