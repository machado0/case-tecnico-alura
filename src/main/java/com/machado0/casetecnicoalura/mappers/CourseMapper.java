package com.machado0.casetecnicoalura.mappers;

import com.machado0.casetecnicoalura.domain.course.Course;
import com.machado0.casetecnicoalura.domain.user.User;
import com.machado0.casetecnicoalura.dto.course.CourseDTO;
import com.machado0.casetecnicoalura.dto.user.UserIdDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        return new CourseDTO(course.getId(),
                course.getCode(),
                course.getName(),
                toUserIdDTO(course.getInstructor()),
                course.getDescription(),
                course.getStatus(),
                course.getCreatedAt(),
                course.getInactivatedAt());
    }

    public Course toEntity(CourseDTO courseDTO) {
        return Course.builder()
                .id(courseDTO.id())
                .code(courseDTO.code())
                .name(courseDTO.name())
                .description(courseDTO.description())
                .instructor(toUserEntity(courseDTO.instructor()))
                .status(courseDTO.status())
                .createdAt(courseDTO.createdAt())
                .inactivatedAt(courseDTO.inactivatedAt())
                .build();
    }

    private UserIdDTO toUserIdDTO(User user) {
        return new UserIdDTO(user.getId());
    }

    private User toUserEntity(UserIdDTO userDTO) {
        return User.builder()
                .id(userDTO.id())
                .build();
    }
}
