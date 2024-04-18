package com.machado0.casetecnicoalura.domain.course.exceptions;

public class CourseNotFoundByCodeException extends RuntimeException {

    public CourseNotFoundByCodeException(String code) {
        super("Course with code " + code + "not found");
    }
}
