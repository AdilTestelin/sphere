package com.adiltestelin.sphere.service;

import com.adiltestelin.sphere.model.dto.RegistrationInputDTO;
import com.adiltestelin.sphere.model.dto.RegistrationOutputDTO;

public interface UserService {

    void registerUser(RegistrationInputDTO registrationInputDTO);

}
