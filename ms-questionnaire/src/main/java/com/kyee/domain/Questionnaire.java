package com.kyee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Questionnaire {
    private long id;
    private String questionnaireName;
    private long startTime;
    private long endTime;
}
