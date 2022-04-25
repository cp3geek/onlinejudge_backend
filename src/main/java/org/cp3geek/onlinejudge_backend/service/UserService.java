package org.cp3geek.onlinejudge_backend.service;

import org.cp3geek.onlinejudge_backend.entity.User;
import org.cp3geek.onlinejudge_backend.util.ResponseResult;

public interface UserService {

    ResponseResult Login(User user);
}
