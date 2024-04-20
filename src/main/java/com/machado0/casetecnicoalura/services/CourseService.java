package com.machado0.casetecnicoalura.services;

import com.machado0.casetecnicoalura.domain.course.Course;
import com.machado0.casetecnicoalura.domain.course.Status;
import com.machado0.casetecnicoalura.domain.course.exceptions.CourseNotFoundByCodeException;
import com.machado0.casetecnicoalura.domain.course.exceptions.CourseNotFoundByIdException;
import com.machado0.casetecnicoalura.domain.user.Role;
import com.machado0.casetecnicoalura.domain.user.User;
import com.machado0.casetecnicoalura.domain.user.exceptions.UserIsNotAnInstructorException;
import com.machado0.casetecnicoalura.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final UserService userService;

    public Course saveCourse(Course course) {
        User instructor = userService.findUserById(course.getInstructor().getId());

        if (!Objects.equals(Role.INSTRUCTOR, instructor.getRole()))
            throw new UserIsNotAnInstructorException(instructor.getUsername());

        return courseRepository.save(course);
    }

    public void inactivateCourse(String code) {
        Course course = courseRepository.findByCode(code)
                .orElseThrow(() -> new CourseNotFoundByCodeException(code));
        course.setInactivatedAt(LocalDateTime.now());
        course.setStatus(Status.INACTIVE);
        courseRepository.save(course);
    }

    public Page<Course> listCoursesByStatus(Status status, Pageable pageable) {
        return courseRepository.findByStatus(status, pageable);
    }

    public Optional<Course> findActiveCourseById(Long id) {
        return courseRepository.findByIdAndIsActive(id);
    }

    public Course findCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundByIdException(id));
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }
}
