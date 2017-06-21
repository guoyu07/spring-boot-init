package com.kyee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 使用@EnableCircuitBreaker注解开启断路器功能
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PathApplication {

    public static void main(String[] args) {
        SpringApplication.run(PathApplication.class, args);
    }
}
