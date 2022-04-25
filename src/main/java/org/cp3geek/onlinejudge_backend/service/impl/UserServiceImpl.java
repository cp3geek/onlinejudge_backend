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
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public User userLogin(String userName) {
        User user=userRepository.findUserByUserName(userName);
        return user;
    }

    @Autowired
    private RedisCache redisCache;

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
