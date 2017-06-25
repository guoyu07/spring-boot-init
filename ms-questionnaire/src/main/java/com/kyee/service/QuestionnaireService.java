package com.kyee.service;

import com.kyee.domain.Questionnaire;

public interface QuestionnaireService {

    int addQuestionnaire(Questionnaire questionnaire);

    Questionnaire getQuestionnaire(long id);
}
