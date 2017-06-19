package com.kyee.controller;

import com.kyee.domain.Course;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable("courseId") long courseId){
        return Course.builder().courseId(courseId).courseName("Effective Java").build();
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        Course course_one = Course.builder().courseId(1L).courseName("refactor").build();
        Course course_two = Course.builder().courseId(2L).courseName("spring boot").build();
        return Arrays.asList(course_one, course_two);
    }
}
