package com.ssafy.spring.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

@PropertySource("classpath:account.properties")
@Component
//@RequiredArgsConstructor
//@Setter

public class JWTUtil {
    @Value("${kakao.jwt.secretKey}")
    private String secretKey;

    @Value("${kakao.client-id}")
    private String clientId;

//    private long tokenValidTime = 1000L * 60 * 60; // 60분
//    private long refreshTokenValidTime = 1000L * 60 * 60 * 24 * 7; // 7일
//
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes()); // 생성되면서 인코딩
    }

    public String getClientId(){
        return clientId;
    }

    // 토큰 생성
    public String createToken(String subject) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + Duration.ofHours(20).toMillis()); //만료 기간 1시간
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        return Jwts.builder()
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("doyeon")
                .setIssuedAt(now)
                .setExpiration(expiration)
                .setSubject(subject) //토큰 제목(주로 이메일로 많이 사용)
                .signWith(signatureAlgorithm, secretKey.getBytes()) //알고리즘, 시크릿 키
                .compact();
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + tokenValidTime))
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
    }

    // JWT 토큰에서 이메일 추출
    public String getAuthIdByJWT(String token) {
        token = BearerRemove(token); // Bearer 제거
        Claims claim = Jwts.parser()
                        .setSigningKey(secretKey.getBytes())
                        .parseClaimsJws(token)
                        .getBody();
        return claim.getSubject();
    }
    
    // JWT 토큰 유효성 검사
    public boolean validateToken(String token){
        try {
            token = this.BearerRemove(token);
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .parseClaimsJws(token);

            // 만료 일자 확인
            if (claims.getBody().getExpiration().before(new Date())) {
                return false;
            }
//            System.out.println(claims.getSignature());
            return true;
        } catch (SignatureException e){
            System.out.println("Invalid JWT Signature" + e);
        } catch (MalformedJwtException e){
            System.out.println("Invalid JWT token" + e);
        } catch (ExpiredJwtException e){
            System.out.println("Expired JWT token" + e);
        } catch (UnsupportedJwtException e){
            System.out.println("Unsupported JWT token" + e);
        } catch (IllegalArgumentException e){
            System.out.println("JWT Claims string is empty" + e);
        }

        return false;

    }

    //==토큰 앞 부분('Bearer') 제거 메소드==//
    private String BearerRemove(String token) {
        return token.substring("Bearer ".length());
    }


//    public String createRefreshToken() {
//        Date now = new Date();
//
//        return Jwts.builder()
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + refreshTokenValidTime))
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
//
//    public boolean validateTokenExpiration(String token) {
//        try {
//            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public String resolveToken(HttpServletRequest req) {
//        return req.getHeader("X-AUTH-TOKEN");
//    }
//
//    public String getUserId(String accesstoken) throws NotValidateAccessToken {
//        try {
//            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(accesstoken).getBody().getSubject();
//        } catch(Exception e) {
//            throw new NotValidateAccessToken();
//        }
//    }

}
