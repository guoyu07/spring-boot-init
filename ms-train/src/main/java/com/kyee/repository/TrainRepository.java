package com.kyee.repository;

import com.kyee.domain.Train;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "trains")    //数据访问接口中，增加缓存配置注解
public interface TrainRepository extends JpaRepository<Train, Long> {

    @Cacheable
    Train findTrainById(long id);
}
