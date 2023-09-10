package com.adiltestelin.sphere.controller;

import com.adiltestelin.sphere.model.dto.RegistrationInputDTO;
import com.adiltestelin.sphere.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/register")
    private ResponseEntity<Void> registerUser(@RequestBody RegistrationInputDTO registrationInputDto) {
        userService.registerUser(registrationInputDto);

        return ResponseEntity.ok().build();
    }
}
