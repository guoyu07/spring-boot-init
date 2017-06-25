package com.kyee.controller;

import com.kyee.domain.Questionnaire;
import com.kyee.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Objects;

@RestController
@RefreshScope
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Value("${ms-questionnaire-profile}")
    private String profile;

    @GetMapping("/profile")
    public String getProfile(){
        return profile;
    }

    @PostMapping("/questionnaires")
    public int addQuestionnaire(@RequestBody Questionnaire questionnaire){
        if(Objects.isNull(questionnaire)){
            long startTime = Instant.now().getEpochSecond();
            long endTime = startTime + 2 * 60 * 60;
            return questionnaireService.addQuestionnaire(Questionnaire.builder().questionnaireName("java questionnaire").startTime(startTime).endTime(endTime).build());
        }
        return questionnaireService.addQuestionnaire(questionnaire);
    }

    @GetMapping("/questionnaires/{id}")
    public Questionnaire getQuestionnaire(@PathVariable long id){
        return questionnaireService.getQuestionnaire(id);
    }
}
