package com.kyee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableCaching  //开启缓存功能
// Spring Boot根据下面的顺序去侦测缓存提供者：
//Generic
//JCache (JSR-107)
//EhCache 2.x
//Hazelcast
//Infinispan
//Redis
//Guava
//Simple
@SpringBootApplication
@EnableDiscoveryClient
public class TrainApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrainApplication.class, args);
    }
}
