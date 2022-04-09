package org.cp3geek.onlinejudge_backend.service;

import org.cp3geek.onlinejudge_backend.entity.User;

public interface UserService {
    User userLogin(String userName,String userPassword);
}
