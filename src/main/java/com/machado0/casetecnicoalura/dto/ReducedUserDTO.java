package com.machado0.casetecnicoalura.dto;

import com.machado0.casetecnicoalura.domain.user.Role;

public record ReducedUserDTO(String name, String email, Role role) {
}
