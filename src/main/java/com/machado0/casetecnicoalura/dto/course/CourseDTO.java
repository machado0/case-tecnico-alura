package com.machado0.casetecnicoalura.dto.course;

import com.machado0.casetecnicoalura.domain.course.Status;
import com.machado0.casetecnicoalura.dto.user.UserDTO;

import java.time.LocalDateTime;

public record CourseDTO(Long id,
                        String code,
                        String name,
                        UserDTO instructor,
                        String description,
                        Status status,
                        LocalDateTime createdAt,
                        LocalDateTime inactivatedAt) {
}
