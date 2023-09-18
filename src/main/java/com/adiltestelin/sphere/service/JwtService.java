package com.adiltestelin.sphere.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String extractUsername(final String token);

    String generateToken(final UserDetails userDetails);

    boolean isTokenValid(final String token, final UserDetails userDetails);
}
