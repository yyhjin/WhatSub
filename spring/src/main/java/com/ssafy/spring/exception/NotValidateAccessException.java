package com.ssafy.spring.exception;

import static com.ssafy.spring.ExceptionMessage.NOT_VALID_ACCESS_MESSAGE;


public class NotValidateAccessException extends Exception {
    public NotValidateAccessException(){super(NOT_VALID_ACCESS_MESSAGE);}
}
