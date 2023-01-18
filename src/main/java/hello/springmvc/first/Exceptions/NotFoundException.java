package hello.springmvc.first.Exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class NotFoundException extends BusinessException {

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND);
    }
}
