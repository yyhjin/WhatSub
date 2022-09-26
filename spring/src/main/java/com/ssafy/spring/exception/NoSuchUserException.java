package com.ssafy.spring.exception;
import static com.ssafy.spring.ExceptionMessage.*;


public class NoSuchUserException extends Exception {
    public NoSuchUserException(){super(NO_SUCH_USER_MESSAGE);}
}
