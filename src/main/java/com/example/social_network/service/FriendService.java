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


    @Transactional
    public void addFriend(String login) {
        var user = userService.getCurrentUser();
        var friend = userService.findByLogin(login).orElseThrow(() -> {
            throw ApiException.builder().accessDenied("Пользователь не найден по логину");
        });

        checkFriend(friend);
        var userToFriend = toEntityFriend(user,friend);
        friendDataService.save(userToFriend);
        var friendToUser = toEntityFriend(friend,user);
        friendDataService.save(friendToUser);
    }

    public List<UserDto> getFriends() {
        var user = userService.getCurrentUser();
        return user.getFriends().stream().map(this::toUserDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteFriendById(Integer id) {
        var user = userService.getCurrentUser();
        var friend = User.builder()
                .id(id)
                .build();
        friendDataService.delete(user, friend);
        friendDataService.delete(friend, user);
    }

    private Friend toEntityFriend(User user, User friend){
        return Friend.builder()
                .user(user)
                .friend(friend)
                .build();
    }

    private UserDto toUserDto(User user){
        return UserDto.builder()
                .login(user.getLogin())
                .email(user.getEmail())
                .build();
    }

    private void checkFriend(User friend){
        var friends = getFriends();
        boolean existsFriend = friends.stream()
                .anyMatch(user -> friend.getLogin().equals(user.getLogin()));

        if (existsFriend) {
            throw ApiException.builder().accessDenied("Пользователь уже есть в друзьях.");
        }
    }
}
