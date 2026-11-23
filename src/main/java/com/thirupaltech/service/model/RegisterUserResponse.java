package com.thirupaltech.service.model;

import com.thirupaltech.service.entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterUserResponse(
        UUID id,
        String fullName,
        String email,
        String phone,
        boolean active,
        LocalDateTime createdAt
) {
    public static RegisterUserResponse from(User user) {
        return new RegisterUserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPhone(),
                user.isActive(),
                user.getCreatedAt()
        );
    }
}