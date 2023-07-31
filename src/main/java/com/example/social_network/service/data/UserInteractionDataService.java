package com.example.social_network.service.data;

import com.example.social_network.mapper.UserMapper;
import com.example.social_network.model.dto.RegistrationUserDto;
import com.example.social_network.model.dto.UserDto;
import com.example.social_network.model.user.User;
import com.example.social_network.repository.UserRepository;
import com.example.social_network.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Дмитрий Карпушов 30.07.2023
 */
@Service
@RequiredArgsConstructor
public class UserInteractionDataService {

    private final UserRepository userRepository;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;


    @Transactional(propagation = Propagation.MANDATORY)
    public User save(RegistrationUserDto registrationUserDto) {
        var user = User.builder()
                .login(registrationUserDto.getLogin())
                .email(registrationUserDto.getEmail())
                .password(passwordEncoder.encode(registrationUserDto.getPassword()))
                .roles(List.of(roleService.getUserRole()))
                .build();
        return userRepository.save(user);
    }

    public Optional<UserDto> findById(Integer id){
        return userRepository.findById(id)
                .map(userMapper::toDto);
    }

    public Optional<UserDto> findByLogin(String login){
        return userRepository.findByLogin(login)
                .map(userMapper::toDto);
    }

    public Optional<UserDto> findByEmail(String email){
        return userRepository.findByLogin(email)
                .map(userMapper::toDto);
    }

}
