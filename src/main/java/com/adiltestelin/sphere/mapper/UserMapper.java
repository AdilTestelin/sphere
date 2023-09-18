package com.adiltestelin.sphere.mapper;

import com.adiltestelin.sphere.model.User;
import com.adiltestelin.sphere.model.dto.RegistrationRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User registrationRequestToUser(final RegistrationRequest registrationInputDTO, final String hashedPassword) {

        return User.builder()
                .mail(registrationInputDTO.mail())
                .username(registrationInputDTO.username())
                .password(hashedPassword)
                .build();
    }
}
