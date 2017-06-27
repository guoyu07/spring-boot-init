package com.kyee.controller;

import com.kyee.domain.Train;
import com.kyee.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class trainController {

    @Autowired
    private TrainRepository trainRepository;

    @GetMapping("/trains/{id}")
    public Train getTrain(@PathVariable("id") long id){
        return trainRepository.findTrainById(id);
    }

    @PostMapping("/trains")
    public Train saveTrain(@RequestBody Train train){
        return trainRepository.save(train);
    }
}
