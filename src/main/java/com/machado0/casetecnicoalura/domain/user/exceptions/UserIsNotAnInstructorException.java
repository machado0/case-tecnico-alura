package com.machado0.casetecnicoalura.domain.user.exceptions;

public class UserIsNotAnInstructorException extends RuntimeException {

    public UserIsNotAnInstructorException(String username) {
        super("User " + username + "is not an Instructor");
    }

}
