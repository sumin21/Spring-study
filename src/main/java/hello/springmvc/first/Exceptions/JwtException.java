package hello.springmvc.first.Exceptions;

public class JwtException extends BusinessException {

    public JwtException() {
        super(ErrorCode.JWT_EXCEPTION);
    }
}