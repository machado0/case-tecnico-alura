package com.machado0.casetecnicoalura.controllers;

import com.machado0.casetecnicoalura.domain.course.Course;
import com.machado0.casetecnicoalura.domain.course.Status;
import com.machado0.casetecnicoalura.dto.course.CourseDTO;
import com.machado0.casetecnicoalura.dto.user.ReducedUserDTO;
import com.machado0.casetecnicoalura.mappers.CourseMapper;
import com.machado0.casetecnicoalura.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @PostMapping
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = courseService.saveCourse(courseMapper.toEntity(courseDTO));
        return courseMapper.toDTO(course);
    }

    @GetMapping
    public Page<CourseDTO> listCoursesByStatus(@RequestParam Status status,
                                          @PageableDefault(size = 15) Pageable pageable) {
        return courseService.listCoursesByStatus(status, pageable)
                .map(courseMapper::toDTO);
    }

    @PutMapping
    public void inactivateCourse(@RequestParam String code) {
        courseService.inactivateCourse(code);
    }
}
