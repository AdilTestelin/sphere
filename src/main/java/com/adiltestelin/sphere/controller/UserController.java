package com.adiltestelin.sphere.controller;

import com.adiltestelin.sphere.model.dto.AuthenticationRequest;
import com.adiltestelin.sphere.model.dto.AuthenticationResponse;
import com.adiltestelin.sphere.model.dto.RegistrationRequest;
import com.adiltestelin.sphere.model.dto.RegistrationResponse;
import com.adiltestelin.sphere.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/users/register")
    public ResponseEntity<RegistrationResponse> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        final RegistrationResponse response = authenticationService.signUp(registrationRequest);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/users/signin")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        final AuthenticationResponse response = authenticationService.signIn(authenticationRequest);

        return ResponseEntity.ok(response);

    }
}
