package com.kyee.controller;

import com.kyee.domain.Course;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 这里@RefreshScope注解不能少，否则即使调用/refresh，配置也不会刷新
 */
@RestController
@RefreshScope
public class CourseController {

    @Value("${ms-course-profile}")
    private String profile;

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

    @GetMapping("/config")
    public String getConfigValue(){
        return profile;
    }
}
