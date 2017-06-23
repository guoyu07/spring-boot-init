package com.kyee.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class QuestionnaireController {
    @Value("${ms-questionnaire-profile}")
    private String profile;

    @GetMapping("/profile")
    public String getProfile(){
        return profile;
    }
}
