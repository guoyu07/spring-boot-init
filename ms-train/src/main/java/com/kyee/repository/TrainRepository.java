package com.kyee.repository;

import com.kyee.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainRepository extends JpaRepository<Train, Long> {

    Train findTrainById(long id);
}
