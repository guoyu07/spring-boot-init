package com.gng.service.impl;


import com.gng.domain.Path;
import com.gng.repository.PathRepository;
import com.gng.service.PathService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathServiceImpl implements PathService{

    private static final int DEFAULT_FROM_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 3;

    @Autowired
    private PathRepository pathRepository;

    @Override
    public List<Path> getPathByName(String name) {
        return pathRepository.findByName(name);
    }

    @Override
    public List<Path> queryPaths(String matchTerm, String value) {
        MatchQueryBuilder queryBuilder = new MatchQueryBuilder(matchTerm, value);
        Pageable pageRequest = new PageRequest(DEFAULT_FROM_PAGE, DEFAULT_PAGE_SIZE);
        Page<Path> responses = pathRepository.search(queryBuilder, pageRequest);
        return responses.getContent();
    }

    @Override
    public void addPath(Path path) {
        pathRepository.save(path);
    }
}
