package com.machado0.casetecnicoalura.domain.user.exceptions;

public class UserNotFoundByUsernameException extends RuntimeException {

    public UserNotFoundByUsernameException(String username) {
        super("User not found by username: " + username);
    }

}
