package com.gng.controller;

import com.gng.common.SearchParam;
import com.gng.domain.Path;
import com.gng.service.PathQueryService;
import com.gng.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PathSearchController {

    @Autowired
    private PathService pathService;
    @Autowired
    private PathQueryService pathQueryService;

    @RequestMapping(value = "/paths/{name}/", method = RequestMethod.GET)
    public List<Path> getPaths(@PathVariable("name") String name){
        return pathService.getPathByName(name);
    }

    @GetMapping("/paths/")
    public List<Path> searchPaths(@RequestParam("matchTermName") String matchTermName,
                                  @RequestParam("matchTermValue") String matchTermValue){
        return pathService.queryPaths(matchTermName, matchTermValue);
    }

    /**
     * @apiParam {String} wd 关键字
     * @apiParam {boolean} highlight 是否需要高亮
     * @apiParam {String} highlightFields 高亮字段
     * @apiParam {String[]} sort 排名排序
     * @apiParam {String[]} andParam 过滤条件(","是关键字段分割，"^"是多值分割)
     * @apiParam {String[]} orParam 过滤条件(","是关键字段分割，"^"是多值分割)
     * @apiParam {String[]} responseField 定制化返回字段
     * @apiParam {Integer} diseaseSize 查询医生数量
     * @apiParam {Integer} randomSize 随机返回的数据，默认是0，表示不随机。
     * @apiParamExample {json} Request-Example:
     * {
     *    "wd":"李",
     *    "highlight":true
     *    "highlightFields":name,analyzeName,title,seniorDeparts.juniorDeparts.departs.name,summary
     *    "sort":hospitalBase.generalScore
     *    "andParam":key1:value1^value2,key2:value1^value2
     *    "orParam":key1:value1^value2,key2:value1^value2
     *    "responseField":name,analyzeName,title
     *    "diseaseSize":3
     * }
     */
    @RequestMapping(value = "/paths/params/",method = RequestMethod.GET)
    public List<Path> queryDisease(SearchParam searchParam){
        return pathQueryService.queryPaths(searchParam);
    }

    //喂数据
    @PostMapping("/paths/")
    public void addPath(@RequestBody Path path){
        pathService.addPath(path);
    }
}
