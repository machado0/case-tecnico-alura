package com.machado0.casetecnicoalura.repositories;

import com.machado0.casetecnicoalura.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
