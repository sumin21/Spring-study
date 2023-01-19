package hello.springmvc.first.JWT;

import hello.springmvc.first.Exceptions.ErrorCode;
import hello.springmvc.first.Exceptions.JwtException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private String secretKey = "secretKey";

    // 토큰 유효시간 30분
    private long tokenValidTime = 1 * 60 * 1000L;

    // JWT 토큰 생성
    private String createToken(final long payload, final String secretKey, final Long tokenValidTime) {
        return Jwts.builder()
                .setSubject(String.valueOf(payload))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidTime))
                .compact();
    }

    public String createAccessToken(final long payload) {
        return createToken(payload, secretKey, tokenValidTime);
    }

    public Long getAccessTokenPayload(String accessToken) {
        try {
            var claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(accessToken)
                    .getBody();

            return Long.parseLong(claims.getSubject());
        } catch (ExpiredJwtException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            throw new JwtException();
        }
    }

    public ErrorCode validateToken(String accessToken) {
        System.out.println(accessToken);
        try {
            var claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(accessToken);
            if(!claims.getBody().getExpiration().before(new Date()) == false) {
                return ErrorCode.FAIL_AUTHENTICATION;
            }
            return null;
        } catch (ExpiredJwtException e){
            return ErrorCode.TOKEN_EXPIRED;
        } catch (Exception e) {
            return ErrorCode.FAIL_AUTHENTICATION;
        }
    }
}
