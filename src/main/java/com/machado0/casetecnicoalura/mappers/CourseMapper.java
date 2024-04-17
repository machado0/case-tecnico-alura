package com.machado0.casetecnicoalura.mappers;

import com.machado0.casetecnicoalura.domain.course.Course;
import com.machado0.casetecnicoalura.domain.user.User;
import com.machado0.casetecnicoalura.dto.course.CourseDTO;
import com.machado0.casetecnicoalura.dto.user.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        return new CourseDTO(course.getId(),
                course.getCode(),
                course.getName(),
                toUserDTO(course.getInstructor()),
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
                .instructor(toUserEntity(courseDTO.instructor()))
                .status(courseDTO.status())
                .createdAt(courseDTO.createdAt())
                .inactivatedAt(courseDTO.inactivatedAt())
                .build();
    }

    private UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(),
                null,
                null,
                null,
                null,
                null,
                null);
    }

    private User toUserEntity(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.id())
                .build();
    }
}
