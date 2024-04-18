package com.machado0.casetecnicoalura.dto.enrollment;

import com.machado0.casetecnicoalura.dto.course.CourseIdDTO;
import com.machado0.casetecnicoalura.dto.user.UserIdDTO;

import java.time.LocalDateTime;

public record EnrollmentDTO(Long id,
                            UserIdDTO user,
                            CourseIdDTO course,
                            LocalDateTime enrolledAt) {
}
