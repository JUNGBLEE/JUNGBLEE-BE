package com.example.jungblee.global.security.jwt;

import com.example.jungblee.global.security.auth.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService customUserDetailsService;

    private String generateToken(String accountId, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(accountId)
                .claim("typ", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000L))
                .compact();
    }

    public String generateAccessToken(String accountId) {
        return generateToken(accountId, "access", jwtProperties.getAccessExp());
    }
    public String resolveToken(HttpServletRequest request) {

        String bearer = request.getHeader(jwtProperties.getHeader());

        if (bearer != null && bearer.startsWith(jwtProperties.getPrefix()))
            return bearer.replace(jwtProperties.getPrefix(), "");
        return null;
    }

    public boolean validateToken(String token) {
        return getBody(token).getExpiration().after(new Date());
    }

    public Authentication getAuthentication(String token) {
        Claims body = getBody(token);

        if (body.getExpiration().before(new Date()))
            throw new RuntimeException();

        UserDetails userDetails = getUserDetails(body);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public Claims getBody(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private UserDetails getUserDetails(Claims body) {
        return customUserDetailsService.loadUserByUsername(body.getSubject());
    }
}
