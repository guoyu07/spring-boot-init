package com.kyee.repository;


import com.kyee.domain.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, Long>{

    Course findByCourseName(String name);   //Course must contain courseName property.
}
