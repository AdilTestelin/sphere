package com.adiltestelin.sphere.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
        @Email String mail,
        @NotNull String password
) {
}
