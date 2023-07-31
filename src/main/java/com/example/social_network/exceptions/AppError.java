package com.example.social_network.exceptions;

import lombok.Data;

import java.util.Date;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@Data
public class AppError {
    private Integer status;

    private String message;

    private Date timestamp;

    public AppError(Integer status, String message) {

        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}