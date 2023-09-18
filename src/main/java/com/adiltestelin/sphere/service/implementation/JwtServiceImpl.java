package com.adiltestelin.sphere.service.implementation;

import com.adiltestelin.sphere.service.JwtService;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtServiceImpl implements JwtService {
  @Override
  public String extractUsername(final String token) {
    return extractClaim(token, Claims::getSubject);
  }

  private <T> T extractClaim(final String token, final UserDetails userDetails) {
    final Claims claims = extractAllClaims(token);
  }

  @Override
  public String generateToken(final UserDetails userDetails) {
    return null;
  }

  @Override
  public boolean isTokenValid(final String token, final UserDetails userDetails) {
    return false;
  }
}
