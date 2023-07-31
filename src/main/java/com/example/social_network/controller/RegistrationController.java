package com.example.social_network.controller;

import com.example.social_network.mapper.UserMapper;
import com.example.social_network.model.dto.RegistrationUserDto;
import com.example.social_network.service.UserInteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/social-network/api/v1/")
public class RegistrationController {

    private final UserInteractionService userInteractionService;

    private final UserMapper userMapper;

    @PostMapping("registration")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        var user = userInteractionService.createNewUser(registrationUserDto);
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
