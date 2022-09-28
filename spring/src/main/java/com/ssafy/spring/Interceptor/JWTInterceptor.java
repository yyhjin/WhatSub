package com.ssafy.spring.interceptor;

import com.ssafy.spring.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JWTInterceptor implements HandlerInterceptor {
    private static final String HEADER_AUTH = "Authorization";

    @Autowired
    private JWTUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String token = request.getHeader(HEADER_AUTH);
//        token = token.substring(7,token.length()); //Bearer 빼는 부분인듯
        if(token != null){
            if(jwtUtil.validateToken(token)){
                return true;
            }else {
//                throw new NotValidateAccessToken();
            }
        }
        throw new Exception("유효하지 않은 접근입니다.");
    }

}
