package com.kyee.feign;

import com.kyee.domain.Exam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 使用@FeignClient("ms-exam")注解绑定ms-exam服务，还可以使用url参数指定一个URL。
 */
@FeignClient(name = "ms-exam")
public interface ExamFeignClient {

    @RequestMapping(value = "/exams", method = RequestMethod.GET)
    List<Exam> getExamsByFeign();
}
