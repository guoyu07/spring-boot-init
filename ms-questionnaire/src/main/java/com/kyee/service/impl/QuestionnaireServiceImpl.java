package com.kyee.service.impl;

import com.kyee.domain.Questionnaire;
import com.kyee.repository.QuestionnaireMapper;
import com.kyee.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService{
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public int addQuestionnaire(Questionnaire questionnaire) {
        return questionnaireMapper.insertQuestionnaire(questionnaire.getQuestionnaireName(), questionnaire.getStartTime(), questionnaire.getEndTime());
    }

    @Override
    public Questionnaire getQuestionnaire(long id) {
        return questionnaireMapper.getById(id);
    }
}
