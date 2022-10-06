package com.ssafy.spring.config;

import com.ssafy.spring.interceptor.JWTInterceptor;
import com.ssafy.spring.interceptor.SignupInterceptor;
import com.ssafy.spring.resolver.ClientIpArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    private final ClientIpArgumentResolver clientIpArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(clientIpArgumentResolver);
    }

    @Autowired
    private JWTInterceptor jwtInterceptor;

    @Autowired
    private SignupInterceptor signupInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 카카오 토큰 확인(주석 해제하고 테스트 가능)
//        registry.addInterceptor(jwtInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/auth/**") //로그인 과정에 필요한 api 호출들 제외
////                .excludePathPatterns("**/auth/**") //로그인 과정에 필요한 api 호출들 제외
//                .excludePathPatterns("/swagger-resources/**", "/swagger-ui.html/**");

        // 설문 가입 여부 확인(미완)
//        registry.addInterceptor(signupInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/auth/**", "/user/**")
//                .excludePathPatterns("/swagger-resources/**", "/swagger-ui.html/**");
    }
}
