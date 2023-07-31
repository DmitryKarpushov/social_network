package com.example.social_network.response;

import com.example.social_network.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse extends BaseResponse {

    private UserDto user;
}
