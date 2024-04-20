package com.machado0.casetecnicoalura.controllers;

import com.machado0.casetecnicoalura.domain.feedback.Feedback;
import com.machado0.casetecnicoalura.dto.feedback.FeedbackDTO;
import com.machado0.casetecnicoalura.mappers.FeedbackMapper;
import com.machado0.casetecnicoalura.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final FeedbackMapper feedbackMapper;

    @PostMapping
    public FeedbackDTO saveFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackService.saveFeedback(feedbackMapper.toEntity(feedbackDTO));
        return feedbackMapper.toDTO(feedback);
    }

    @GetMapping("/report")
    public String getNPSReport() {
        return feedbackService.createReport();
    }
}
