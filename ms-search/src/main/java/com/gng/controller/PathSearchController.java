package com.gng.controller;

import com.gng.domain.Path;
import com.gng.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PathSearchController {

    @Autowired
    private PathService pathService;

    @RequestMapping(value = "/paths/{name}/", method = RequestMethod.GET)
    public List<Path> getPaths(@PathVariable("name") String name){
        return pathService.getPathByName(name);
    }

    @GetMapping("/paths/")
    public List<Path> searchPaths(@RequestParam("matchTermName") String matchTermName,
                                  @RequestParam("matchTermValue") String matchTermValue){
        return pathService.queryPaths(matchTermName, matchTermValue);
    }

    //喂数据
    @PostMapping("/paths/")
    public void addPath(@RequestBody Path path){
        pathService.addPath(path);
    }
}
