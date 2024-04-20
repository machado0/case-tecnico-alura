package com.machado0.casetecnicoalura.services;

import com.machado0.casetecnicoalura.domain.course.exceptions.CourseNotActiveException;
import com.machado0.casetecnicoalura.domain.enrollment.Enrollment;
import com.machado0.casetecnicoalura.domain.enrollment.exceptions.UserAlreadyEnrolledException;
import com.machado0.casetecnicoalura.repositories.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    private final CourseService courseService;

    public Enrollment saveEnrollment(Enrollment enrollment) {
        if (enrollmentRepository.findByUserIdAndCourseId(enrollment.getUser().getId(), enrollment.getCourse().getId()).isPresent())
            throw new UserAlreadyEnrolledException(enrollment.getUser().getId());

        if (courseService.findActiveCourseById(enrollment.getCourse().getId()).isEmpty())
            throw new CourseNotActiveException(enrollment.getCourse().getId());

        if (isNull(enrollment.getEnrolledAt()))
            enrollment.setEnrolledAt(LocalDateTime.now());

        return enrollmentRepository.save(enrollment);
    }

    public int countByCourseId(Long courseId) {
        return enrollmentRepository.countByCourseId(courseId);
    }
}
