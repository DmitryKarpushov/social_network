package com.example.social_network.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer code; //user.not.found
    private String message;
}
