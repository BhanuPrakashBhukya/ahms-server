package com.plea11.ahms.Utils;

import com.plea11.ahms.config.Constants;
import com.plea11.ahms.models.Hotels;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtUtil implements Serializable {

    private static final long serialVersionUID = 8419518275678192755L;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getAudience);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(Constants.SIGNING_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        Hotels hotels = ((Hotels) authentication.getPrincipal());
        return Jwts.builder()
                .setAudience(String.valueOf(((Hotels) authentication.getPrincipal()).getId()))
                .setSubject(hotels.getName())
                .signWith(SignatureAlgorithm.HS256, Constants.SIGNING_KEY)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .claim(Constants.SERVICE_NAME, "ahms")
                .setExpiration(new Date(System.currentTimeMillis() + Constants.ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        final String uUsername = (String) userDetails.getUsername();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
