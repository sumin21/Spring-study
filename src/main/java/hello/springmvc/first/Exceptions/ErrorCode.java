package hello.springmvc.first.Exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "INVALID INPUT VALUE"),
    WRONG_PASSWORD(HttpStatus.UNAUTHORIZED, "WRONG PASSWORD"),
    FAIL_AUTHENTICATION(HttpStatus.UNAUTHORIZED, "FAIL AUTHENTICATION"), // 로그인X 유저의 요청 OR 토큰 불일(?)
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "TOKEN EXPIRED"), // 엑세스 토큰 만료
    FAIL_AUTHORIZATION(HttpStatus.FORBIDDEN, "FAIL AUTHORIZATION"), // 권한 없는 요청
    JWT_EXCEPTION(HttpStatus.FORBIDDEN, "JWT EXCEPTION"), // 토큰 문제 (JWT)
    NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND"),
    DUPLICATED_USER(HttpStatus.CONFLICT, "DUPLICATED USER"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR");

    private final HttpStatus status;
    private final String message;
}
