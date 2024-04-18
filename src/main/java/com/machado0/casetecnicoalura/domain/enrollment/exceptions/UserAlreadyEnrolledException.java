package com.machado0.casetecnicoalura.domain.enrollment.exceptions;

public class UserAlreadyEnrolledException extends RuntimeException {

    public UserAlreadyEnrolledException(Long id) {
        super("User with the ID " + id + " already enrolled in this course");
    }
}
