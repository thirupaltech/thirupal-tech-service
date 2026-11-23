package com.thirupaltech.service.service;

import com.thirupaltech.service.entity.User;
import com.thirupaltech.service.model.RegisterUserRequest;
import com.thirupaltech.service.model.RegisterUserResponse;
import com.thirupaltech.service.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public RegisterUserResponse register(RegisterUserRequest request) {
        String email = request.email().trim().toLowerCase(Locale.ROOT);
        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email is already registered");
        }

        User user = new User(
                request.fullName().trim(),
                email,
                request.phone() == null || request.phone().isBlank() ? null : request.phone().trim(),
                passwordEncoder.encode(request.password())
        );

        try {
            return RegisterUserResponse.from(userRepository.saveAndFlush(user));
        } catch (DataIntegrityViolationException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email is already registered", exception);
        }
    }

    @Transactional(readOnly = true)
    public RegisterUserResponse login(String email, String password) {
        User user = userRepository.findByEmail(email.trim().toLowerCase(Locale.ROOT))
                .filter(User::isActive)
                .filter(candidate -> candidate.getPasswordHash() != null
                        && passwordEncoder.matches(password, candidate.getPasswordHash()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));

        return RegisterUserResponse.from(user);
    }
}