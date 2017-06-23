package com.kyee.domain.others;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {

    private ResponseStatus status;
    private String message;
    private T data;
    private int count;

}
