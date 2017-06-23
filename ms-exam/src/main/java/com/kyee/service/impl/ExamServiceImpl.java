package com.kyee.service.impl;

import com.kyee.domain.Exam;
import com.kyee.service.ExamService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Override
    @Cacheable(value = "dayExams", key = "'exam_'+#day")
    public List<Exam> getDayExams(int day) {
        Exam exam_one = Exam.builder().examId(1L).examName("html Exam").build();
        Exam exam_two = Exam.builder().examId(1L).examName("css Exam").build();
        Exam exam_three = Exam.builder().examId(1L).examName("javascript Exam").build();
        return Arrays.asList(exam_one, exam_two, exam_three);
    }
}
