package com.kyee.controller;

import com.kyee.config.RedisClient;
import com.kyee.domain.Exam;
import com.kyee.domain.others.Response;
import com.kyee.domain.others.ResponseStatus;
import com.kyee.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class RedisController {
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private ExamService examService;
    @Autowired
    private CacheManager cacheManager;

    private static final String DAY_EXAMS_PREFIX = "dayExams_ksjyw";

    @RequestMapping(value = "/days/{day}/exams", method = RequestMethod.GET)
    public List<Exam> getDayExams(@PathVariable(value = "day") int day){
        return examService.getDayExams(day);
    }

    @RequestMapping(value = "/caches/{cacheName}", method = RequestMethod.DELETE)
    public Response clearCacheNamespace(@PathVariable("cacheName") final String cacheName){
        cacheManager.getCache(cacheName).clear();
        return Response.builder().message("clear namespace "+cacheName+" success")
                       .status(ResponseStatus.SUCCESS).build();
    }

    @RequestMapping(value = "/days/exams", method = RequestMethod.DELETE)
    public Response clearAllDayExamsRedis(){
        Set<String> keys = redisClient.keys();
        int hitNum = 0;
        int deletedNum = 0;
        for(String key : keys){
            if(key.startsWith(DAY_EXAMS_PREFIX)){
                hitNum ++;
                if(redisClient.delete(key)){
                    deletedNum ++;
                }
            }
        }
        return Response.builder().count(deletedNum)
                .status(ResponseStatus.SUCCESS)
                .message("delete operation success, total item number is "+hitNum+
                         ", and success deleted number is "+deletedNum)
                .build();
    }
}
