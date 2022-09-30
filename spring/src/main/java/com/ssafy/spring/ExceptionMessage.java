package com.ssafy.spring;

public interface ExceptionMessage {
    // 예외처리 실패의 메세지
    String FAIL = "FAIL";

    // 존재하지 않는 유저 메세지
    String NO_SUCH_USER_MESSAGE = "[ERROR] 존재하지 않는 유저입니다.";

    String NOT_VALID_ACCESS_TOKEN_MESSAGE = "[ERROR] 유효하지 않은 토큰입니다.";

    String NOT_VALID_ACCESS_MESSAGE = "[ERROR] 유효하지 않은 접근입니다.";
}
