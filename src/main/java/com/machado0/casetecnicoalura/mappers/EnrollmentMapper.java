package com.machado0.casetecnicoalura.mappers;

import com.machado0.casetecnicoalura.domain.course.Course;
import com.machado0.casetecnicoalura.domain.enrollment.Enrollment;
import com.machado0.casetecnicoalura.domain.user.User;
import com.machado0.casetecnicoalura.dto.course.CourseIdDTO;
import com.machado0.casetecnicoalura.dto.enrollment.EnrollmentDTO;
import com.machado0.casetecnicoalura.dto.user.UserIdDTO;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {

    public EnrollmentDTO toDTO(Enrollment enrollment) {
        return new EnrollmentDTO(enrollment.getId(),
                toUserIdDTO(enrollment.getUser()),
                toCourseIdDTO(enrollment.getCourse()),
                enrollment.getEnrolledAt());
    }

    public Enrollment toEntity(EnrollmentDTO enrollmentDTO) {
        return Enrollment.builder()
                .id(enrollmentDTO.id())
                .user(toUserEntity(enrollmentDTO.user()))
                .course(toCourseEntity(enrollmentDTO.course()))
                .enrolledAt(enrollmentDTO.enrolledAt())
                .build();
    }

    private UserIdDTO toUserIdDTO(User user) {
        return new UserIdDTO(user.getId());
    }

    private User toUserEntity(UserIdDTO userIdDTO) {
        return User.builder()
                .id(userIdDTO.id())
                .build();
    }

    private CourseIdDTO toCourseIdDTO(Course course) {
        return new CourseIdDTO(course.getId());
    }

    private Course toCourseEntity(CourseIdDTO courseIdDTO) {
        return Course.builder()
                .id(courseIdDTO.id())
                .build();
    }

}
