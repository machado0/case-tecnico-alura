package com.machado0.casetecnicoalura.services;

import com.machado0.casetecnicoalura.config.EmailSender;
import com.machado0.casetecnicoalura.domain.course.Course;
import com.machado0.casetecnicoalura.domain.feedback.Feedback;
import com.machado0.casetecnicoalura.repositories.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    private final CourseService courseService;

    private final UserService userService;

    private final EnrollmentService enrollmentService;

    public Feedback saveFeedback(Feedback feedback) {
        Feedback savedFeedback = feedbackRepository.save(feedback);

        if (savedFeedback.getRating() < 6) {
            Course course = courseService.findCourseById(savedFeedback.getCourse().getId());
            String recipientEmail = userService.findUserById(course.getInstructor().getId()).getEmail();
            String subject = "Course " + course.getCode() + " received feedback";
            String body = "The course " + course.getName() + "received a feedback with a rating of " + feedback.getRating() + ".\n" +
                    "The full feedback is: \n" + feedback.getText();
            EmailSender.send(recipientEmail, subject, body);
        }

        return savedFeedback;
    }

    public String createReport() {
        StringBuilder report = new StringBuilder("NPS Report: \n");

        courseService.findAllCourses().forEach(c -> {
            if (enrollmentService.countByCourseId(c.getId()) > 4) {
                report.append("\nCourse: ").append(c.getName()).append("\n");
                report.append("Course code: ").append(c.getCode()).append("\n");
                report.append("Instructor: ").append(c.getInstructor().getName()).append("\n");
                report.append("NPS: ").append(calculateNPS(c.getId())).append("\n");
            }
        });

        return report.toString();
    }

    private Long calculateNPS(Long courseId) {
        List<Feedback> courseFeedbacks = feedbackRepository.findByCourseId(courseId);

        long promoters = courseFeedbacks.stream()
                .filter(f -> f.getRating() >= 9)
                .count();
        long positiveOrNeutrals = courseFeedbacks.stream()
                .filter(f -> f.getRating() < 9 && f.getRating() > 6)
                .count();
        long detractors = courseFeedbacks.stream()
                .filter(f -> f.getRating() <= 6)
                .count();

        long responses = promoters + positiveOrNeutrals + detractors;

        if (Objects.equals(responses, 0L))
            return 0L;

        double promotersDivision = (promoters * 1.0) / responses;
        double detractorsDivision = (detractors * 1.0) / responses;

        return Math.round((promotersDivision - detractorsDivision) * 100);
    }

}
