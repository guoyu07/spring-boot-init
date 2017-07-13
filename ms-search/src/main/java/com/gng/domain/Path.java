package com.gng.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "resources",
          type = "path",
          shards = 1,
          replicas = 0)
public class Path {
    @Id
    private long pathId;

    private String name;

    @Field(type = FieldType.Nested)
    private List<Course> courses;
    @Field(type = FieldType.Nested)
    private List<Exam> exams;
}
