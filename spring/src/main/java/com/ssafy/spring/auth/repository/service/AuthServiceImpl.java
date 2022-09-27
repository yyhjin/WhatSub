package com.ssafy.spring.auth.repository.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssafy.spring.auth.dto.KakaoTokenInfo;
import com.ssafy.spring.auth.dto.KakaoUserInfo;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;

@Service
public class AuthServiceImpl implements AuthService{

    public KakaoTokenInfo getTokenByCode(String code){
        String reqURL = "https://kauth.kakao.com/oauth/token";
        KakaoTokenInfo kakaoTokenInfo = null;

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            
            //account.properties 파일에 있는 client-id를 참조
            Properties properties = new Properties();
            String rootPath = new File(".").getAbsolutePath();
            String clientId = "";

            try {
                final String accountPath = rootPath + "/src/main/resources/account.properties";
                properties.load(new FileInputStream(accountPath));
                clientId = properties.getProperty("kakao.client-id");
            } catch (IOException e){
                e.printStackTrace();
            }

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            String sb = "grant_type=authorization_code" +
                    "&client_id=" + clientId + // REST_API_KEY 입력
                    "&redirect_uri=http://localhost:8080/whatsub/v1/auth/kakao" + // 인가코드 받은 redirect_uri 입력
                    "&code=" + code;
            bw.write(sb);
            bw.flush();

            int responseCode = conn.getResponseCode();
            BufferedReader br;
            StringBuilder result = new StringBuilder();

            if(responseCode > 299){ //에러 코드 출력
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String line = "";

                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                br.close();

                System.out.println(result);
            }
            else { //결과 코드가 200이라면 성공
                //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";

                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                br.close();

                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create();
                kakaoTokenInfo = gson.fromJson(result.toString(), KakaoTokenInfo.class);

                return kakaoTokenInfo;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return kakaoTokenInfo;
    }

    @Override
    public KakaoUserInfo getUserByAccessToken(String accessToken) {
        String reqURL = "h https://kapi.kakao.com/v2/user/me";
        KakaoUserInfo kakaoUserInfo = null;

        URL url = null;
        try {
            url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);

//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return kakaoUserInfo;
    }
}
