package com.cheery.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * desc: 异常信息响应类
 * Created by FanYanGen on 2019/4/18 15:40
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {

    private Integer status;

    private String message;

    private Map<String, Object> infos;

    public static ExceptionResponse create(Integer status, String message, Map<String, Object> infos) {
        return new ExceptionResponse(status, message, infos);
    }

}
