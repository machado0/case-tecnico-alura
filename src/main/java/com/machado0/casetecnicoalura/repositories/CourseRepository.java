package com.machado0.casetecnicoalura.repositories;

import com.machado0.casetecnicoalura.domain.course.Course;
import com.machado0.casetecnicoalura.domain.course.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByStatus(Status status,
                              Pageable pageable);

    @Query("SELECT c FROM Course c " +
            "WHERE c.id = :id " +
            "AND c.status = com.machado0.casetecnicoalura.domain.course.Status.ACTIVE")
    Optional<Course> findByIdAndIsActive(Long id);

    Optional<Course> findByCode(String code);
}
