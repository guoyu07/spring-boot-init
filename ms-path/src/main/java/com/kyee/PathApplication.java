package com.kyee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PathApplication {

    public static void main(String[] args) {
        SpringApplication.run(PathApplication.class, args);
    }
}
