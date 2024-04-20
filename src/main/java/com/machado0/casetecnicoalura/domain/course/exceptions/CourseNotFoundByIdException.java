package com.machado0.casetecnicoalura.domain.course.exceptions;

public class CourseNotFoundByIdException extends RuntimeException {

    public CourseNotFoundByIdException(Long id) {
        super("Course with ID " + id + "not found");
    }
}
