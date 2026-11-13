package com.thirupaltech.service.controller;

import com.thirupaltech.service.model.RegisterUserRequest;
import com.thirupaltech.service.model.RegisterUserResponse;
import com.thirupaltech.service.model.LoginUserRequest;
import com.thirupaltech.service.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRegistrationService userRegistrationService;

    public UserController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterUserResponse register(@Valid @RequestBody RegisterUserRequest request) {
        return userRegistrationService.register(request);
    }

    @PostMapping("/login")
    public RegisterUserResponse login(@Valid @RequestBody LoginUserRequest request) {
        return userRegistrationService.login(request.email(), request.password());
    }
}