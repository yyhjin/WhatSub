package com.ssafy.spring.exception;

import static com.ssafy.spring.ExceptionMessage.NOT_VALID_ACCESS_TOKEN_MESSAGE;


public class NotValidateAccessTokenException extends Exception {
    public NotValidateAccessTokenException(){super(NOT_VALID_ACCESS_TOKEN_MESSAGE);}
}
