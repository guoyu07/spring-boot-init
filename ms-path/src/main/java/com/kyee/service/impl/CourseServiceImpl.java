package com.kyee.service.impl;


import com.kyee.domain.Course;
import com.kyee.service.CourseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService{
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     */
    @Override
    @HystrixCommand(fallbackMethod = "getCoursesFallback")
    public List<Course> getCourses(){
        // http://服务提供者的serviceId/url
        return restTemplate.getForObject("http://ms-course/"+"courses", List.class);
    }

    /**
     * hystrix fallback方法
     */
    private List<Course> getCoursesFallback(){
        log.error("getCourses method error");
        Course course =Course.builder().courseId(-1L).courseName("fallback course").build();
        return Collections.singletonList(course);
    }
}
