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

    @Length(max = 10)
    @NotBlank
    @Pattern(regexp = "^[a-z\\-]+$")
    @Column(unique = true)
    private String code;

    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User instructor;

    @NotBlank
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime inactivatedAt;
}
