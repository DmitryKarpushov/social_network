package com.example.social_network.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
}
