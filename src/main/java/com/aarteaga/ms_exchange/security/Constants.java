package com.aarteaga.ms_exchange.security;

import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constants {
    // Spring Security
    public static final String LOGIN_URL = "/user/login";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT
    public static final String SUPER_SECRET_KEY = "eyJhbGciOiJIUzI1NiJ9.ew0KICAibmFtZSI6ICJBbGlzc29uIiwNCn0.CLwywD806lSFKCVd6JBDlSZhDnv8yOX1VSP8-BToCiI";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

    public static Key getSigningKey(String secret) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
