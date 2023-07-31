package com.example.social_network.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

    private String login;

    private String email;
}
