package com.machado0.casetecnicoalura.domain.feedback;

import com.machado0.casetecnicoalura.domain.course.Course;
import com.machado0.casetecnicoalura.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false, name = "course_id")
    private Course course;

    @NotBlank(message = "Please provide a rating for the course")
    @Min(value = 0, message = "Please provide a rating with a minimum value of 0")
    @Max(value = 10, message = "Please provide a rating with a maximum value of 10")
    private int rating;

    @NotBlank(message = "Please provide a motive for the feedback")
    private String text;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
