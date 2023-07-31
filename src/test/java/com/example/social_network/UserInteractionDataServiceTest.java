package com.example.social_network;

import com.example.social_network.mapper.UserMapper;
import com.example.social_network.model.dto.RegistrationUserDto;
import com.example.social_network.model.dto.UserDto;
import com.example.social_network.model.user.Role;
import com.example.social_network.model.user.User;
import com.example.social_network.repository.UserRepository;
import com.example.social_network.service.RoleService;
import com.example.social_network.service.data.UserInteractionDataService;
import com.example.social_network.utils.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * @author Дмитрий Карпушов 01.08.2023
 */
@ExtendWith(MockitoExtension.class)
public class UserInteractionDataServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleService roleService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserInteractionDataService userInteractionDataService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testSave() {
        var registrationUserDto = RegistrationUserDto.builder()
                .login("Dima")
                .confirmPassword("111")
                .password("111")
                .email("Dima@Gmail.com")
                .build();
        var user = User.builder()
                .id(1)
                .email("Dima@Gmail.com")
                .login("Dima")
                .password("111")
                .build();

        when(roleService.getUserRole()).thenReturn(Role.builder().id(1).name(Roles.ROLE_USER.name()).build());
        when(passwordEncoder.encode(registrationUserDto.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(user)).thenReturn(user);


        verify(roleService, times(1)).getUserRole();
        verify(passwordEncoder, times(1)).encode(registrationUserDto.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testFindById() {
        Integer userId = 1;

        var user = User.builder()
                .id(1)
                .email("Dima@Gmail.com")
                .login("Dima")
                .password("123456789")
                .build();
        var userDto = UserDto.builder()
                .login("Dima")
                .email("Dima@Gmail.com")
                .build();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.toDto(user)).thenReturn(userDto);

        verify(userRepository, times(1)).findById(userId);
        verify(userMapper, times(1)).toDto(user);
    }

    @Test
    public void testFindByLogin() {
        String login = "userLogin";

        var user = User.builder()
                .id(1)
                .email("Dima@Gmail.com")
                .login("Dima")
                .password("123456789")
                .build();
        var userDto = UserDto.builder()
                .login("Dima")
                .email("Dima@Gmail.com")
                .build();

        when(userRepository.findByLogin(login)).thenReturn(Optional.of(user));
        when(userMapper.toDto(user)).thenReturn(userDto);

        verify(userRepository, times(1)).findByLogin(login);
        verify(userMapper, times(1)).toDto(user);
    }
}