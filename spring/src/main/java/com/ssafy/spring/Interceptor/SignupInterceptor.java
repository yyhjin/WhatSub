package com.ssafy.spring.interceptor;

import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.UserService;
import com.ssafy.spring.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SignupInterceptor implements HandlerInterceptor  {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String accessToken = request.getHeader("Authorization");
        String authId = jwtUtil.getAuthIdByJWT(accessToken);
        User user = userService.getUserByAuthId(authId);

        if(user.getUserName() == null){
            System.out.println("설문조사 안함!");
            response.sendRedirect(request.getContextPath() + "/signup");
            return false;
        }
        return true;
    }
}
