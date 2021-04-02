package com.coallet.semilla.adapter.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {

    private String id;
    private Integer status;
    private String resource;
    private T data;

}
