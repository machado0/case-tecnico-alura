package com.machado0.casetecnicoalura.mappers;

import com.machado0.casetecnicoalura.domain.user.User;
import com.machado0.casetecnicoalura.dto.user.ReducedUserDTO;
import com.machado0.casetecnicoalura.dto.user.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public ReducedUserDTO toReducedDTO(User user) {
        return new ReducedUserDTO(user.getName(),
                user.getEmail(),
                user.getRole());
    }

    public User toEntity(UserDTO userDTO) {
        return User.builder()
                .email(userDTO.email())
                .name(userDTO.name())
                .password(userDTO.password())
                .role(userDTO.role())
                .build();
    }

}
