package com.example.social_network.mapper;

import com.example.social_network.model.dto.UserDto;
import com.example.social_network.model.user.User;
import org.mapstruct.Mapper;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */

@Mapper(componentModel = "spring")
public interface UserMapper {


    public UserDto toDto(User user);

    public User toEntity(UserDto userDto);
}
