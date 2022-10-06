package com.ssafy.spring.interceptor;

import com.ssafy.spring.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class JWTInterceptor implements HandlerInterceptor {
    private static final String HEADER_AUTH = "Authorization";
    private final JWTUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }

        String token = request.getHeader(HEADER_AUTH);

        if(token != null){
            if(jwtUtil.validateToken(token)){
                System.out.println("[ERROR]: validate token!");
                return true;
            } else {
                System.out.println("[ERROR]: not validate token!");
                response.sendRedirect("https://j7a105.p.ssafy.io/login");
                return false;
//                throw new NotValidateAccessTokenException();
            }
        }
        System.out.println("[ERROR]: token is null!");
        response.sendRedirect("https://j7a105.p.ssafy.io/login");
        return false;
//        throw new NotValidateAccessException();
    }

}
