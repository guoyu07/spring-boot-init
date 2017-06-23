package com.kyee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RedisClient {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private boolean exists(final String key){
        return redisTemplate.hasKey(key);
    }

    public Object get(final String key){
        ValueOperations operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    public Set<String> keys(){
        return redisTemplate.keys("*");
    }

    public boolean delete(final String key){
        if(exists(key)){
            redisTemplate.delete(key);
            return true;
        }
        return false;
    }
}
