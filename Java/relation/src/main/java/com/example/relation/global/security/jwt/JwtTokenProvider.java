package com.example.relation.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // 1. application.properties에 있는 변수 가져오기
    @Value("${jwt.secret}")
    private String secretKey;

    // 2. 만료기간을 위한 기간 지정 (이것도 jwt.변수명으로 해도 됨)
    private final long tokenValidityInMilliseconds = 1000L * 60 * 60 * 24; // 1시간 (실습 편의를 위해서 24 곱함)

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(Authentication authentication) {

        // 1. payload에 담을 username 가져오기(유저를 식별하기 위함)
        String username = authentication.getName();
        // 2. claims(payload에 들어갈 정보)에 username 넣어주기 (jwt에 값을 넣어주기 위한 장치)
        // subject : username 방식으로 데이터를 넣음 (사실상 중요한 정보라, pk같은...)
        Claims claims = Jwts.claims().setSubject(username);

        // 만료일 지정
        Date now = new Date();
        Date validity = new Date(now.getTime() + tokenValidityInMilliseconds);

        return Jwts.builder()
                // payload 채우기
                .setClaims(claims)
                // 만든시간 넣기
                .setIssuedAt(now)
                // 만료시간 넣기
                .setExpiration(validity)
                // 서명 넣기
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}
