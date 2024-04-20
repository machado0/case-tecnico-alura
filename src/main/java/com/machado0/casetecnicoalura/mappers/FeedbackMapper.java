package com.machado0.casetecnicoalura.mappers;

import com.machado0.casetecnicoalura.domain.course.Course;
import com.machado0.casetecnicoalura.domain.feedback.Feedback;
import com.machado0.casetecnicoalura.domain.user.User;
import com.machado0.casetecnicoalura.dto.course.CourseIdDTO;
import com.machado0.casetecnicoalura.dto.feedback.FeedbackDTO;
import com.machado0.casetecnicoalura.dto.user.UserIdDTO;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {

    public FeedbackDTO toDTO(Feedback feedback) {
        return new FeedbackDTO(feedback.getId(),
                toUserIdDTO(feedback.getUser()),
                toCourseIdDTO(feedback.getCourse()),
                feedback.getRating(),
                feedback.getText(),
                feedback.getCreatedAt());
    }

    public Feedback toEntity(FeedbackDTO feedbackDTO) {
        return Feedback.builder()
                .id(feedbackDTO.id())
                .user(toUserEntity(feedbackDTO.user()))
                .course(toCourseEntity(feedbackDTO.course()))
                .rating(feedbackDTO.rating())
                .text(feedbackDTO.text())
                .createdAt(feedbackDTO.createdAt())
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
