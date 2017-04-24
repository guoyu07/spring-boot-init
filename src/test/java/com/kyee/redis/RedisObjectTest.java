package com.kyee.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class RedisObjectTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisObject(){
        Student student1 = new Student(1, 18, "Tom");
        redisTemplate.opsForValue().set(student1.getName(), student1);
        Student student2 = new Student(1, 19, "Alice");
        redisTemplate.opsForValue().set(student2.getName(), student2);
        Student student3 = new Student(1, 20, "Jerry");
        redisTemplate.opsForValue().set(student3.getName(), student3);

        Assert.assertEquals(18, ((Student)redisTemplate.opsForValue().get("Tom")).getAge());
        Assert.assertEquals(19, ((Student)redisTemplate.opsForValue().get("Alice")).getAge());
        Assert.assertEquals(20, ((Student)redisTemplate.opsForValue().get("Jerry")).getAge());
    }
}
