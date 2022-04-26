package org.cp3geek.onlinejudge_backend.handler;

import com.alibaba.fastjson.JSON;
import org.cp3geek.onlinejudge_backend.util.ResponseResult;
import org.cp3geek.onlinejudge_backend.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //处理异常
        ResponseResult result=new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"认证失败请重新登陆");
        String json= JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}
