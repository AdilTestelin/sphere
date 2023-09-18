package com.adiltestelin.sphere.service;

import com.adiltestelin.sphere.model.dto.AuthenticationRequest;
import com.adiltestelin.sphere.model.dto.AuthenticationResponse;
import com.adiltestelin.sphere.model.dto.RegistrationRequest;
import com.adiltestelin.sphere.model.dto.RegistrationResponse;

public interface AuthenticationService {
    RegistrationResponse signUp(final RegistrationRequest registrationRequest);

    AuthenticationResponse signIn(final AuthenticationRequest authenticationRequest);
}
