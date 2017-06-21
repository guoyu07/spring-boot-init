package com.kyee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {

    private long examId;
    private String examName;
    private long startTime;
    private long duration;
}
