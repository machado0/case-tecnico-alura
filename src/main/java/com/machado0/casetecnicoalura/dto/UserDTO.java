package com.machado0.casetecnicoalura.dto;

import com.machado0.casetecnicoalura.domain.user.Role;

import java.time.LocalDateTime;

public record UserDTO(Long id,
                      String name,
                      String username,
                      String email,
                      String password,
                      Role role,
                      LocalDateTime createdAt) {
}
