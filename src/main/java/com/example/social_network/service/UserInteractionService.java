package com.example.social_network.service;

import com.example.social_network.exceptions.ApiException;
import com.example.social_network.model.dto.RegistrationUserDto;
import com.example.social_network.model.dto.UserDto;
import com.example.social_network.model.user.User;
import com.example.social_network.service.data.UserInteractionDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Дмитрий Карпушов 30.07.2023
 */
@Service
@RequiredArgsConstructor
public class UserInteractionService {

    private final UserInteractionDataService userInteractionDataService;

    @Transactional
    public User createNewUser(RegistrationUserDto registrationUserDto) {
        return userInteractionDataService.save(registrationUserDto);
    }


    public UserDto findUserByLogin(String login) {
        return userInteractionDataService.findByLogin(login).orElseThrow(() -> {
            throw ApiException.builder().accessDenied("Пользователь не найден по логину");
        });
    }


    public UserDto findUserById(Integer id) {
        return userInteractionDataService.findById(id)
                .orElseThrow(() -> {
                    throw ApiException.builder().accessDenied("Пользователь не найден по id");
                });
    }

}
