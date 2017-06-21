package com.kyee.controller;

import com.kyee.domain.Exam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ExamController {

    @GetMapping("/exams")
    public List<Exam> getExams(){
        Exam exam_one = Exam.builder().examId(1L).examName("java Exam").build();
        Exam exam_two = Exam.builder().examId(1L).examName("python Exam").build();
        return Arrays.asList(exam_one, exam_two);
    }
}
