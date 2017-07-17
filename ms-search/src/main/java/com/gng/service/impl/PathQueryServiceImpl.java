package com.gng.service.impl;

import com.gng.common.SearchParam;
import com.gng.domain.Course;
import com.gng.domain.Exam;
import com.gng.domain.Path;
import com.gng.service.PathQueryService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class PathQueryServiceImpl implements PathQueryService{

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<Path> queryPaths(SearchParam searchParam){
        String wd = searchParam.getWd();
        SearchQuery queryBuilder = new NativeSearchQueryBuilder()
                .withQuery(
                        boolQuery()
                            .should(matchQuery("name", wd).boost(.9f))
                ).build();
        return elasticsearchOperations.query(queryBuilder,(t) -> getPaths(t));
    }

    private List<Path> getPaths(SearchResponse response){
        List<Path> result = new ArrayList<>();
        long count = response.getHits().getTotalHits();
        if(count > 0){
            for(SearchHit hit : response.getHits().getHits()){
                result.add(Path.builder()
                        .pathId((int) hit.getSource().get("pathId"))
                        .name((String)hit.getSource().get("name"))
                        .courses(getCourses((ArrayList<Map<String, Object>>) hit.getSource().get("courses")))
                        .exams(getExams((ArrayList<Map<String, Object>>) hit.getSource().get("exams")))
                        .build());
            }
        }
        return result;
    }

    private List<Course> getCourses(ArrayList<Map<String, Object>> listOfMap){
        List<Course> courses = new ArrayList<>();
        for(Map<String, Object> map : listOfMap){
            Course course = Course.builder()
                    .courseId((int) map.get("courseId"))
                    .courseName((String) map.get("courseName"))
                    .startTime((int) map.get("startTime"))
                    .endTime((int) map.get("endTime"))
                    .build();
            courses.add(course);
        }
        return courses;
    }

    private List<Exam> getExams(ArrayList<Map<String, Object>> listOfMap){
        List<Exam> exams = new ArrayList<>();
        for(Map<String, Object> map : listOfMap){
            Exam exam = Exam.builder()
                    .examId((int) map.get("examId"))
                    .examName((String) map.get("examName"))
                    .startTime((int) map.get("startTime"))
                    .duration((int) map.get("duration"))
                    .build();
            exams.add(exam);
        }
        return exams;
    }

}
