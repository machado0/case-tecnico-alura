package com.machado0.casetecnicoalura.domain.user.exceptions;

public class UserNotFoundByIdException extends RuntimeException {

    public UserNotFoundByIdException(Long id) {
        super("User not found by ID: " + id);
    }

}
