package org.cp3geek.onlinejudge_backend.service.impl;

import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.repository.UserRepository;
import org.cp3geek.onlinejudge_backend.service.UserService;
import org.cp3geek.onlinejudge_backend.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
//    @Override
//    public User userLogin(String userName) {
//        User user=userRepository.findUserByUserName(userName);
//        return user;
//    }

    @Override
    public ResponseResult Login(User user) {
        // AuthenticationManager authenticate进行用户认证
        //如果认证没通过，给出对应提示
        //如果认证通过了，使用ueseid生成jwt，jwt存入ResponseResult返回
        //把完整用户信息存入redis，userid作为key
        return null;
    }
}
