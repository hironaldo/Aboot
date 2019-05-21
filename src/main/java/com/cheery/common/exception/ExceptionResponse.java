package com.cheery.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * desc:
 * Created by FanYanGen on 2019/4/18 15:40
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {

    private Integer code;

    private String message;

    private Map<String, Object> request;

    public static ExceptionResponse create(Integer code, String message, Map<String, Object> request) {
        return new ExceptionResponse(code, message, request);
    }

}
