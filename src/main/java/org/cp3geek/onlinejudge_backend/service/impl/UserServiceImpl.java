package org.cp3geek.onlinejudge_backend.service.impl;

import org.cp3geek.onlinejudge_backend.domain.LoginUser;
import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.repository.UserRepository;
import org.cp3geek.onlinejudge_backend.service.UserService;
import org.cp3geek.onlinejudge_backend.util.JwtUtil;
import org.cp3geek.onlinejudge_backend.util.RedisCache;
import org.cp3geek.onlinejudge_backend.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public User userLogin(String userName) {
        User user=userRepository.findUserByUserName(userName);
        return user;
    }

    @Override
    public ResponseResult logout() {
        //获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser=(LoginUser)authentication.getPrincipal();
        Long userId = loginUser.getUser().getUserId();
        //删除redis中的值
        redisCache.deleteObject("login:"+userId);
        return new ResponseResult(200,"注销成功");
    }


    @Override
    public ResponseResult Login(User user) {
        // AuthenticationManager authenticate进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken
                (user.getUserName(),user.getUserPassword());
        Authentication authenticate=authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，给出对应提示
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登陆失败");
        }
        //如果认证通过了，使用ueseid生成jwt，jwt存入ResponseResult返回
        LoginUser loginUser=(LoginUser)authenticate.getPrincipal();
        String userid=loginUser.getUser().getUserId().toString();
        String jwt= JwtUtil.createJWT(userid);
        Map<String,String> map=new HashMap<>();
        map.put("token",jwt);
        //把完整用户信息存入redis，userid作为key
        redisCache.setCacheObject("login:"+userid,loginUser);
        return new ResponseResult(200,"登陆成功",map);
    }


}
