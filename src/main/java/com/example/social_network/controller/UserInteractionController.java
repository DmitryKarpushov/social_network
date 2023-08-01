package com.example.social_network.controller;

import com.example.social_network.service.UserInteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Дмитрий Карпушов 30.07.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/social-network/api/v1/user/")
public class UserInteractionController {

    private final UserInteractionService userInteractionService;

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> findUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userInteractionService.findUserById(id));
    }

    @GetMapping("login/{login}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> findUserByLogin(@PathVariable String login) {
        return ResponseEntity.ok(userInteractionService.findUserByLogin(login));
    }

    @GetMapping("email/{email}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userInteractionService.findUserByEmail(email));
    }
}
