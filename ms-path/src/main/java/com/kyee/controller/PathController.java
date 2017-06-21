package com.kyee.controller;

import com.kyee.domain.Path;
import com.kyee.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathController {
    @Autowired
    private PathService pathService;

    @GetMapping("/paths/{pathId}") //spring 4.3的新注解, 与下面的等价
    //@RequestMapping(value = "/paths/{pathId}", method = RequestMethod.GET)
    public Path getPath(@PathVariable("pathId") long pathId){
//        Course course_one = Course.builder().courseId(1L).courseName("refactor").build();
//        Course course_two = Course.builder().courseId(2L).courseName("spring boot").build();
//        Exam exam_one = Exam.builder().examId(1L).examName("refactor exam").build();
//        Exam exam_two = Exam.builder().examId(2L).examName("spring boot exam").build();
//        return Path.builder().pathId(pathId)
//                   .courses(Arrays.asList(course_one, course_two))
//                   .exams(Arrays.asList(exam_one, exam_two)).build();
        return pathService.getPath(pathId);
    }
}
