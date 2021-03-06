package com.kyee.service.impl;

import com.kyee.domain.Path;
import com.kyee.feign.ExamFeignClient;
import com.kyee.service.CourseService;
import com.kyee.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathServiceImpl implements PathService{
    @Autowired
    private CourseService courseService;
    @Autowired
    private ExamFeignClient examFeignClient;

    @Override
    public Path getPath(long pathId){
        return Path.builder().pathId(pathId)
                   .courses(courseService.getCourses())
                   .exams(examFeignClient.getExamsByFeign())
                   .build();
    }
}
