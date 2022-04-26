package org.cp3geek.onlinejudge_backend.handler;

import com.alibaba.fastjson.JSON;
import org.cp3geek.onlinejudge_backend.util.ResponseResult;
import org.cp3geek.onlinejudge_backend.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult result=new ResponseResult(HttpStatus.FORBIDDEN.value(), "您没有访问权限");
        String json= JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}
