package com.kyee.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

interface StudentRepository extends MongoRepository<Student, Long>{

    Student findByName(String name);
}
