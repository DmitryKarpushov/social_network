package com.example.social_network.service;

import com.example.social_network.exceptions.ApiException;
import com.example.social_network.mapper.ConvertEntityDto;
import com.example.social_network.model.dto.UserDto;
import com.example.social_network.service.data.FriendDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
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

    private final ConvertEntityDto convertEntityDto;

    private final UserInteractionService userInteractionService;

    @Transactional
    public void addFriendByLogin(String login) {
        var user = userService.getCurrentUser();
        var friend = convertEntityDto.toUser(userInteractionService.findUserByLogin(login));

        var userToFriend = convertEntityDto.toEntityFriend(user, friend);
        var friendToUser = convertEntityDto.toEntityFriend(friend, user);
        try {
            friendDataService.save(userToFriend);
            friendDataService.save(friendToUser);
        } catch (DataIntegrityViolationException e) {
            throw ApiException.builder().conflict("Данный друг уже добавлен");
        }
    }

    public List<UserDto> getFriends() {
        var user = userService.getCurrentUser();
        return user.getFriends().stream().map(convertEntityDto::toUserDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteFriendById(Integer id) {
        var user = userService.getCurrentUser();
        var friend = convertEntityDto.toUser(userInteractionService.findUserById(id));

        friendDataService.delete(user, friend);
        friendDataService.delete(friend, user);
    }

}
