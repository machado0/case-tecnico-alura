package com.machado0.casetecnicoalura.controllers;

import com.machado0.casetecnicoalura.domain.enrollment.Enrollment;
import com.machado0.casetecnicoalura.dto.enrollment.EnrollmentDTO;
import com.machado0.casetecnicoalura.mappers.EnrollmentMapper;
import com.machado0.casetecnicoalura.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final EnrollmentMapper enrollmentMapper;

    @PostMapping
    public EnrollmentDTO saveEnrollment(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentService.saveEnrollment(enrollmentMapper.toEntity(enrollmentDTO));
        return enrollmentMapper.toDTO(enrollment);
    }

}
