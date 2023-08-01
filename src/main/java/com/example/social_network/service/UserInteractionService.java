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
        checkUser(registrationUserDto);
        return userInteractionDataService.save(registrationUserDto);
    }


    public UserDto findUserByLogin(String login) {
        return userInteractionDataService.findByLogin(login).orElseThrow(() -> {
            throw ApiException.builder().notFound("Пользователь не найден по логину");
        });
    }

    public UserDto findUserByEmail(String email) {
        return userInteractionDataService.findByEmail(email).orElseThrow(() -> {
            throw ApiException.builder().notFound("Пользователь не найден по email");
        });
    }

    public UserDto findUserById(Integer id) {
        return userInteractionDataService.findById(id)
                .orElseThrow(() -> {
                    throw ApiException.builder().notFound("Пользователь не найден по id");
                });
    }

    private void checkUser(RegistrationUserDto registrationUserDto) {
        var existingUserByLogin = userInteractionDataService.findByLogin(registrationUserDto.getLogin());
        var existingUserByEmail = userInteractionDataService.findByEmail(registrationUserDto.getEmail());

        if (existingUserByLogin.isPresent() || existingUserByEmail.isPresent()) {
            throw ApiException.builder().conflict("Пользователь с таким login или email уже существует.");
        }
    }

}
