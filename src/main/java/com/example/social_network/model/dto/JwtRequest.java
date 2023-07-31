package com.example.social_network.model.dto;

import lombok.Data;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@Data
public class JwtRequest {

    private String username;

    private String password;
}
