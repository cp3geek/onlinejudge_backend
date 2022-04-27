package org.cp3geek.onlinejudge_backend.service.impl;

import org.cp3geek.onlinejudge_backend.domain.LoginUser;
import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<String>list=new ArrayList<>(Arrays.asList("test"));//这个用jpa去数据库中查询权限信息即可

        //把数据封装成userdetails返回
        return new LoginUser(user,list);
    }
}
