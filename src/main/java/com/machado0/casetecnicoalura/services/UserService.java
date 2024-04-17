package com.machado0.casetecnicoalura.services;

import com.machado0.casetecnicoalura.domain.user.User;
import com.machado0.casetecnicoalura.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

}
