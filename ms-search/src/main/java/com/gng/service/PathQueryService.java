package com.gng.service;


import com.gng.common.SearchParam;
import com.gng.domain.Path;

import java.util.List;

public interface PathQueryService {

    List<Path> queryPaths(SearchParam searchParam);
}
