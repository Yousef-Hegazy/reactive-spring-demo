package com.yousef.reactiveWS.presentation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateUserRequest(
        @NotBlank
        @NotEmpty
        @Size(min = 3, max = 20, message = "Firstname must be between 3 and 20 characters")
        String firstname,

        @NotBlank
        @NotEmpty
        @Size(min = 3, max = 20, message = "Lastname must be between 3 and 20 characters")
        String lastname,

        @Email(message = "Empty or Invalid email")
        String email,

        @NotBlank
        @NotEmpty
        @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
        String password
) {
}
