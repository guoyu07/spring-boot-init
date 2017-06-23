package com.kyee.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.DefaultRedisCachePrefix;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisConfig {

    private static final String PREFIX = "_ksjyw:";
    private static final long DEFAULT_EXPIRATION = 1200L;
    private static final long SECONDS_OF_ONE_DAY = 86400L;
    private static final long SECONDS_OF_ONE_WEEK = 86400L * 7;
    private static final long NEVER_EXPIRE = 0;

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(DEFAULT_EXPIRATION);
        redisCacheManager.setUsePrefix(true);
        redisCacheManager.setCachePrefix(new DefaultRedisCachePrefix(PREFIX));

        Map<String, Long> expires = new HashMap<>(8);
        expires.put("mostOftenExams", NEVER_EXPIRE);
        expires.put("dayExams", SECONDS_OF_ONE_DAY);
        expires.put("weekExam", SECONDS_OF_ONE_WEEK);
        expires.put("temporaryExam", SECONDS_OF_ONE_DAY);
        redisCacheManager.setExpires(expires);
        return redisCacheManager;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }
}
