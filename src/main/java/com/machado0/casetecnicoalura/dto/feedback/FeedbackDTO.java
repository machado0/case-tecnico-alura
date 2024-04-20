package com.machado0.casetecnicoalura.dto.feedback;

import com.machado0.casetecnicoalura.dto.course.CourseIdDTO;
import com.machado0.casetecnicoalura.dto.user.UserIdDTO;

import java.time.LocalDateTime;

public record FeedbackDTO(Long id,
                          UserIdDTO user,
                          CourseIdDTO course,
                          int rating,
                          String text,
                          LocalDateTime createdAt) {
}
