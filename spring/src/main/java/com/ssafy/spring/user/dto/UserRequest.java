package com.ssafy.spring.user.dto;

import lombok.Data;
import lombok.Getter;

public class UserRequest {

    @Getter
    public class GetSubtiRequest {
        int userId;
        String subti;
    }

    public class SignUpRequest{

    }

    public class LoginRequest{

    }

    public class ExcludeRequest{

    }
}

