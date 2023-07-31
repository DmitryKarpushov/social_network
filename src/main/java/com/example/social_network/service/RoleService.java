package com.example.social_network.service;

import com.example.social_network.exceptions.ApiException;
import com.example.social_network.model.user.Role;
import com.example.social_network.service.data.RoleDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleDataService roleDataService;

    public Role getUserRole() {
        return roleDataService.getUserRole().orElseThrow(() -> {
            throw ApiException.builder().accessDenied("Роль ROLE_USER не найдена");
        });
    }

}
