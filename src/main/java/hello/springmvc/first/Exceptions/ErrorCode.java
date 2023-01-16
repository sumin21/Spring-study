package hello.springmvc.first.Exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "INVALID INPUT VALUE");

    private final int status;
    private final String message;
}
