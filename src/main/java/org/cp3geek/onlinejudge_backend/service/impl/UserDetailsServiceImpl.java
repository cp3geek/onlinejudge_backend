package org.cp3geek.onlinejudge_backend.service.impl;

import org.cp3geek.onlinejudge_backend.domain.LoginUser;
import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        User user=userService.userLogin(username);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名不存在");
        }
        //TODO 查询对应的权限信息


        //把数据封装成userdetails返回
        return new LoginUser(user);
    }
}
