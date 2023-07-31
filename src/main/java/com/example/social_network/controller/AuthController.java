package com.example.social_network.controller;

import com.example.social_network.model.dto.JwtRequest;
import com.example.social_network.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/social-network/api/v1/")
public class AuthController {

    private final AuthService authService;

    @PostMapping("auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

}
