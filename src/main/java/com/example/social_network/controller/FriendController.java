package com.example.social_network.controller;

import com.example.social_network.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Дмитрий Карпушов 30.07.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/social-network/api/v1/friend")
public class FriendController {

    private final FriendService friendService;

    @PostMapping("/{login}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> addFriendByLogin(@PathVariable String login) {
        friendService.addFriendByLogin(login);
        return ResponseEntity.ok(friendService.getFriends());
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> showFriends() {
        return ResponseEntity.ok(friendService.getFriends());
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> deleteFriendById(@PathVariable Integer id) {
        friendService.deleteFriendById(id);
        return ResponseEntity.ok(friendService.getFriends());
    }
}
