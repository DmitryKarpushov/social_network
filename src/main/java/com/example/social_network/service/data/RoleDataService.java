package com.example.social_network.service.data;

import com.example.social_network.model.user.Role;
import com.example.social_network.repository.RoleRepository;
import com.example.social_network.utils.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Дмитрий Карпушов 30.07.2023
 */
@Service
@RequiredArgsConstructor
public class RoleDataService {

    private final RoleRepository roleRepository;

    public Optional<Role> getUserRole() {
        return roleRepository.findByName(Roles.ROLE_USER.name());
    }

}
