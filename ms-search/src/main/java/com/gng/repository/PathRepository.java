package com.gng.repository;


import com.gng.domain.Path;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PathRepository extends ElasticsearchRepository<Path, Long> {

    List<Path> findByName(String name);
}