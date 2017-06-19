package com.kyee.service.impl;

import com.kyee.domain.Course;
import com.kyee.domain.Path;
import com.kyee.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PathServiceImpl implements PathService{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Path getPath(long pathId){
        // http://服务提供者的serviceId/url
        List<Course> courses = restTemplate.getForObject("http://ms-course/"+"courses", List.class);
        return Path.builder().pathId(pathId).courses(courses).build();
    }
}
