package com.kyee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Train {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String trainName;
    @Column
    private String startTime;
    @Column
    private String endTime;
}
