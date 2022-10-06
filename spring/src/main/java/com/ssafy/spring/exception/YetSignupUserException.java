package com.ssafy.spring.exception;

import static com.ssafy.spring.ExceptionMessage.YET_SIGNUP_USER_MESSAGE;


public class YetSignupUserException extends Exception {
    public YetSignupUserException(){super(YET_SIGNUP_USER_MESSAGE);}
}
