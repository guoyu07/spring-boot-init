package com.kyee.controller;

import com.kyee.domain.Train;
import com.kyee.repository.TrainRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Slf4j
public class trainController {
    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/trains/{id}")
    public Train getTrain(@PathVariable("id") long id){
        Collection<String> cacheNames = cacheManager.getCacheNames();
        for(String cacheName : cacheNames){
            Cache cache = cacheManager.getCache(cacheName);
            log.info("name:{}, nativeCache:{}", cache.getName(), cache.getNativeCache());
        }

        return trainRepository.findTrainById(id);
    }

    @PostMapping("/trains")
    public Train saveTrain(@RequestBody Train train){
        return trainRepository.save(train);
    }
}
