package com.kyee.feign;

import com.kyee.domain.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 */
@FeignClient(name = "ms-course", fallback = CourseFeignClient.CourseFeignClientFallback.class)
public interface CourseFeignClient {

    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
    Course getCourseByFeign(@PathVariable("courseId") int courseId);

    /**
     * 将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类;
     * 这边采取了和Spring Cloud官方文档相同的做法;
     */
    @Component
    @Slf4j
    class CourseFeignClientFallback implements CourseFeignClient{
        /**
         * hystrix fallback方法
         */
        @Override
        public Course getCourseByFeign(int courseId) {
            log.error("getCourses method error");
           return Course.builder().courseId(-1L).courseName("fallback course").build();
        }
    }
}
