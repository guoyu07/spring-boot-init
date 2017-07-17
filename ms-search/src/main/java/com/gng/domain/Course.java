package com.gng.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    private long courseId;

    private String courseName;
    private long startTime;
    private long endTime;
}
