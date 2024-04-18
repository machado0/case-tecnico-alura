package com.machado0.casetecnicoalura.controllers;

import com.machado0.casetecnicoalura.domain.user.User;
import com.machado0.casetecnicoalura.dto.user.ReducedUserDTO;
import com.machado0.casetecnicoalura.dto.user.UserDTO;
import com.machado0.casetecnicoalura.mappers.UserMapper;
import com.machado0.casetecnicoalura.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ReducedUserDTO saveUser(@RequestBody UserDTO userDTO) {
        User user = userService.saveUser(userMapper.toEntity(userDTO));
        return userMapper.toReducedDTO(user);
    }

    @GetMapping
    public ReducedUserDTO findUserByUsername(@RequestParam String username) {
        return userMapper.toReducedDTO(userService.findUserByUsername(username));
    }

}
