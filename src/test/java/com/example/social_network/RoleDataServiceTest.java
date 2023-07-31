package com.example.social_network;

import com.example.social_network.model.user.Role;
import com.example.social_network.repository.RoleRepository;
import com.example.social_network.service.data.RoleDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.social_network.utils.Roles.ROLE_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Дмитрий Карпушов 31.07.2023
 */
@ExtendWith(MockitoExtension.class)
public class RoleDataServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleDataService roleDataService;

    @Test
    public void testGetUserRole() {
        Role roleUser = Role.builder().name(ROLE_USER).build();
        when(roleRepository.findByName(ROLE_USER.name())).thenReturn(Optional.of(roleUser));
        Optional<Role> result = roleDataService.getUserRole();
        assertEquals(Optional.of(roleUser), result);
    }
}