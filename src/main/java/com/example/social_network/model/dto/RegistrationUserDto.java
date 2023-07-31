package com.example.social_network.model.dto;

import lombok.*;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationUserDto {

    private String login;

    private String password;

    private String confirmPassword;

    private String email;

}

