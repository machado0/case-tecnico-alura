package com.machado0.casetecnicoalura.repositories;

import com.machado0.casetecnicoalura.domain.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    List<Feedback> findByCourseId(Long id);

}
