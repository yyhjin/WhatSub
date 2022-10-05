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
//        System.out.println("인터셉터에서 토큰 헤더 얻기 " + token);

        if(token != null){
            if(jwtUtil.validateToken(token)){
                System.out.println("토큰 인증 완료!");
                return true;
            }else {
                System.out.println("유효하지 않은 토큰!");
                response.sendRedirect("/login");
//                throw new NotValidateAccessTokenException();
            }
        }
        return false;
//        throw new NotValidateAccessException();
    }

}
