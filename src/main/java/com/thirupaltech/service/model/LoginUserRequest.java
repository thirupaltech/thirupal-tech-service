package com.thirupaltech.service.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginUserRequest(
        @NotBlank @Email @Size(max = 150) String email,
        @NotBlank @Size(max = 72) String password
) {
}