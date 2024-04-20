package com.machado0.casetecnicoalura.repositories;

import com.machado0.casetecnicoalura.domain.enrollment.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Optional<Enrollment> findByUserIdAndCourseId(Long userId, Long courseId);

    int countByCourseId(Long courseId);

}
