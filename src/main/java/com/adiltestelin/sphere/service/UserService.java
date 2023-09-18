package com.adiltestelin.sphere.service;

import com.adiltestelin.sphere.model.dto.RegistrationInputDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    void registerUser(RegistrationInputDTO registrationInputDTO);
    UserDetailsService userDetailsService();


}
