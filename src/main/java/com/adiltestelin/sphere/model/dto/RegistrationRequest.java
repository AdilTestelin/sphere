package com.adiltestelin.sphere.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RegistrationRequest(
        @Email String mail,
        @NotNull String username,
        @NotNull String password
) {
}
