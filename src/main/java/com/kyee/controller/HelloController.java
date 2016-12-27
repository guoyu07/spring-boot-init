package com.kyee.controller;

import com.kyee.config.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//controller 如果单独使用，需要配合模板
//@Controller
//@ResponseBody

//RestController组合注解 == @Controller + @RespondBody
@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${email}")
    private String email;

    @Value("${content}")
    private String content;

    //推荐方式
    @Autowired
    private StudentProperties studentProperties;

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = {"/hello","/hi"})
    public String say(){
        String info = "hello "+name+" spring boot! "+email + ", "+ content;
        return info + ":" +studentProperties.getName()+ "," + studentProperties.getEmail();
    }

    //模板，不建议使用，前后端分离
//    @GetMapping(value = "/index")
//    public String index(){
//        return "index";
//    }
}
