package com.kyee.controller;

import com.kyee.domain.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable("courseId") long courseId){
        return Course.builder().courseId(courseId).courseName("Effective Java").build();
    }
}
