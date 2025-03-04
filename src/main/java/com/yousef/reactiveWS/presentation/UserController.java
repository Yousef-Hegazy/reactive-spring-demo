package com.yousef.reactiveWS.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Users API")
public class UserController {
//    private final UsersService usersService;

    @PostMapping
    public Mono<ResponseEntity<UserDto>> createUser(@RequestBody @Valid Mono<CreateUserRequest> mono) {
        return mono.map(r ->
                UserDto.builder()
                        .id(UUID.randomUUID())
                        .firstname(r.firstname())
                        .lastname(r.lastname())
                        .email(r.email())
                        .build()
        ).map(dto -> ResponseEntity.created(URI.create("/users/" + dto.id())).body(dto));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserDto>> getUserById(@PathVariable UUID id) {
        return Mono.just(
                UserDto.builder()
                        .id(UUID.randomUUID())
                        .email("test@test.com")
                        .firstname("John")
                        .lastname("Doe")
                        .build()
        ).map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<UserDto> getUsers(
            @RequestParam(required = false, defaultValue = "1", value = "page") Integer page,
            @RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize
    ) {
        return Flux.fromIterable(List.of(
                UserDto.builder()
                        .id(UUID.randomUUID())
                        .email("").build()
        ));
    }
}
