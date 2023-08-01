package com.example.social_network.mapper;

import com.example.social_network.model.dto.UserDto;
import com.example.social_network.model.friend.Friend;
import com.example.social_network.model.user.User;
import org.springframework.stereotype.Component;

/**
 * @author Дмитрий Карпушов 01.08.2023
 */
@Component
public class ConvertEntityDto {

    public Friend toEntityFriend(User user, User friend){
        return Friend.builder()
                .user(user)
                .friend(friend)
                .build();
    }

    public UserDto toUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .email(user.getEmail())
                .build();
    }

    public User toUser(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .email(userDto.getEmail())
                .build();
    }
}
