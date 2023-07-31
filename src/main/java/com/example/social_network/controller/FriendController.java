package com.example.social_network.controller;


import com.example.social_network.model.dto.UserDto;
import com.example.social_network.model.user.User;
import com.example.social_network.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Дмитрий Карпушов 30.07.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/social-network/api/v1/friend/")
public class FriendController {

    private final FriendService friendService;

    @PostMapping("{login}")
    @ResponseStatus(code = HttpStatus.OK)
    public void addFriend(@PathVariable String login) {
        friendService.addFriend(login);
    }

    @GetMapping("list")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> showFriends() {
        return ResponseEntity.ok(friendService.getFriends());
    }

    /**
     * id - пользователя которого хотим удалить.
     */
    @DeleteMapping("delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteFriendById(@PathVariable Integer id) {
        friendService.deleteFriendById(id);
    }
}
