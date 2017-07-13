package com.gng.service;


import com.gng.domain.Path;

import java.util.List;

public interface PathService {

    List<Path> getPathByName(String name);

    List<Path> queryPaths(String matchTerm, String value);

    void addPath(Path path);
}
