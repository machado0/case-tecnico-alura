package com.machado0.casetecnicoalura.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please provide a name")
    private String name;

    @Length(max = 20, message = "Please provide a username with a max of 20 characters")
    @NotBlank(message = "Please provide a username")
    @Pattern(regexp = "^[a-z]+$", message = "Please provide a username with no numbers or special characters")
    @Column(unique=true)
    private String username;

    @Email(message = "Please provide a valid e-mail")
    @NotBlank(message = "Please provide an e-mail")
    @Column(unique=true)
    private String email;

    @NotBlank(message = "Please provide a password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
