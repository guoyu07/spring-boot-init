package com.kyee.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data

@Component
@ConfigurationProperties(prefix = "student")
public class StudentProperties {
    private String name;
    private String email;
}
