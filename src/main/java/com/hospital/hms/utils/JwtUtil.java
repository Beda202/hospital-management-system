package com.hospital.hms.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
   @Value("${spring.app.jwtSecret}")
    private  String jwtSecret ;

    @Value("${spring.app.jwtExpirationMs}")
    private long jwtAccessExpirationMs;

    @Value("${spring.app.jwtRefreshExpirationMs}")
    private long refreshTokenExpiration;

    private SecretKey  getSigningKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(jwtSecret));
    }
    public String generateAccessToken(UserDetails userDetails){
     return    Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("role", userDetails.getAuthorities()
                        .stream()
                        .map(auth -> auth.getAuthority())
                        .toList())
                .claim("token_type","ACCESS")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtAccessExpirationMs))
                .signWith(getSigningKey())
                .compact();
    }

    public String generateRefreshToken(UserDetails userDetails){
        return    Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("token_type","REFRESH")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpiration))
                .signWith(getSigningKey())
                .compact();
    }
    public boolean isAccessToken(String token) {
        String type = Jwts.parser()
                .verifyWith( getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("token_type", String.class);
        return "ACCESS".equals(type);
    }

    public boolean isRefreshToken(String token) {
        String type = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("token_type", String.class);
        return "REFRESH".equals(type);
    }

    public String extractUserName(String token){
        return extractClaims(token , Claims::getSubject);
    }

    private <T>T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token) ;
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
      return   Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
              .parseSignedClaims(token)
              .getPayload();

    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isTokenExpired(String token){
        try {
            final Date expiration = extractClaims(token, Claims::getExpiration);
            return expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    public long getRemainingExpiration(String token) {
        Date expirationDate = Jwts.parser()
                .verifyWith( getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();

        long now = System.currentTimeMillis();
        long diffInMillis = expirationDate.getTime() - now;

        return Math.max(diffInMillis , 0);
    }
}
