package com.machado0.casetecnicoalura.domain.course.exceptions;

public class CourseNotActiveException extends RuntimeException {

    public CourseNotActiveException(Long id) {
        super("Course with ID "+ id + "not active");
    }
}
