package com.kyee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用@EnableCircuitBreaker注解开启断路器功能
 * 使用@EnableFeignClients开启Feign
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
public class PathApplication {

    public static void main(String[] args) {
        SpringApplication.run(PathApplication.class, args);
    }
}
