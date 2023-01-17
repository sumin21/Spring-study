package hello.springmvc.first.Exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class NotFoundException extends RuntimeException{
    private final ErrorCode code;

    public NotFoundException(ErrorCode code) {
        this.code = code;
    }

    public NotFoundException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }
}
