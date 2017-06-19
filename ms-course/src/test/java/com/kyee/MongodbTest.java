package com.kyee;

import com.kyee.domain.Course;
import com.kyee.repository.CourseRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MongodbTest {

    @Autowired
    private CourseRepository courseRepository;

    @Before
    public void setUp(){
        courseRepository.deleteAll();
    }

    @Test
    public void testMongodb(){
        courseRepository.save(Course.builder().courseId(1L).courseName("Effective Java").build());
        courseRepository.save(Course.builder().courseId(2L).courseName("Java 8 In Action").build());
        courseRepository.save(Course.builder().courseId(3L).courseName("Spring Boot In Action").build());
        Assert.assertEquals(3, courseRepository.findAll().size());

        courseRepository.delete(1L);
        Assert.assertEquals(2, courseRepository.findAll().size());

        Course s = courseRepository.findByCourseName("Java 8 In Action");
        courseRepository.delete(s);
        Assert.assertEquals(1, courseRepository.findAll().size());
    }
}
