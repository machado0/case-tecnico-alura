package com.machado0.casetecnicoalura.domain.course;

import com.machado0.casetecnicoalura.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 10, message = "Please provide a code with a max of 10 characters")
    @NotBlank(message = "Please provide a code")
    @Pattern(regexp = "^[a-z\\-]+$", message = "Please provide a valid code, with no numbers or special characters other than '-'")
    @Column(unique = true)
    private String code;

    @NotBlank(message = "Please provide a name")
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User instructor;

    @NotBlank(message = "Please provide a description")
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime inactivatedAt;
}
