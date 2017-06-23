package com.kyee.service;


import com.kyee.domain.Exam;

import java.util.List;

public interface ExamService {

    List<Exam> getDayExams(int day);
}
