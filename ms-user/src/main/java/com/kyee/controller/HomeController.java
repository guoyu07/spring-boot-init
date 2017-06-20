package com.kyee.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(){
        return "home";
    }

    @GetMapping("/helloUser")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String helloUser(){
        return "helloUser";
    }

    @GetMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String helloAdmin(){
        return "helloAdmin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
