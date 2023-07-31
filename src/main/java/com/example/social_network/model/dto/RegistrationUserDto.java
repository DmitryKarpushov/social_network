package com.example.social_network.model.dto;

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
public class RegistrationUserDto {

    private String login;

    private String password;

    private String confirmPassword;

    private String email;

}

