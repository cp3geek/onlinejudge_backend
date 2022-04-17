package org.cp3geek.onlinejudge_backend.service.impl;

import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.repository.UserRepository;
import org.cp3geek.onlinejudge_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User userLogin(String userName) {
        User user=userRepository.findUserByUserName(userName);
        return user;
    }
}
