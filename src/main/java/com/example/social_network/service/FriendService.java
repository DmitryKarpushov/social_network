package com.example.social_network.service;

import com.example.social_network.exceptions.ApiException;
import com.example.social_network.mapper.UserMapper;
import com.example.social_network.model.dto.UserDto;
import com.example.social_network.model.friend.Friend;
import com.example.social_network.model.user.User;
import com.example.social_network.service.data.FriendDataService;
import com.example.social_network.service.data.UserInteractionDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Дмитрий Карпушов 30.07.2023
 */
@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendDataService friendDataService;

    private final UserService userService;

    private final UserMapper userMapper;

    @Transactional
    public void addFriend(String login) {
        var user = userService.getCurrentUser();

        var friend = userService.findByLogin(login).orElseThrow(() -> {
            throw ApiException.builder().accessDenied("Пользователь не найден по логину");
        });

        var userToFriend = Friend.builder()
                .user(user)
                .friend(friend)
                .build();
        friendDataService.save(userToFriend);
        var friendToUser = Friend.builder()
                .user(friend)
                .friend(user)
                .build();
        friendDataService.save(friendToUser);
    }

    public List<UserDto> getFriends() {
        var user = userService.getCurrentUser();
        return user.getFriends().stream().map(s -> UserDto.builder()
                .login(s.getLogin())
                .email(s.getEmail())
                .build()).collect(Collectors.toList());
    }

    @Transactional
    public void deleteFriendById(Integer id) {
        var user = userService.getCurrentUser();
        var ent = User.builder()
                .id(id)
                .build();
        friendDataService.delete(user, ent);
        friendDataService.delete(ent, user);
    }
}
