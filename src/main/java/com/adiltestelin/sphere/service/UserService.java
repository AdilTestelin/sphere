package com.adiltestelin.sphere.service;

import com.adiltestelin.sphere.model.dto.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();


}
