package com.yousef.reactiveWS.presentation;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserDto(
        UUID id,
        String firstname,
        String lastname,
        String email
) {
}
