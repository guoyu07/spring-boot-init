//package com.kyee.mongodb;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class MongodbTest {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Before
//    public void setUp(){
//        studentRepository.deleteAll();
//    }
//
//    @Test
//    public void testMongodb(){
//        studentRepository.save(new Student(1L, 18, "tom"));
//        studentRepository.save(new Student(2L, 19, "jerry"));
//        studentRepository.save(new Student(3L, 20, "foo"));
//        Assert.assertEquals(3, studentRepository.findAll().size());
//
//        studentRepository.delete(1L);
//        Assert.assertEquals(2, studentRepository.findAll().size());
//
//        Student s = studentRepository.findByName("foo");
//        studentRepository.delete(s);
//        Assert.assertEquals(1, studentRepository.findAll().size());
//    }
//}
