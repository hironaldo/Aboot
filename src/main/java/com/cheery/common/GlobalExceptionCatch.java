package com.cheery.common;

import com.cheery.common.exception.BusinessException;
import com.cheery.common.exception.ExceptionResponse;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * desc: 全局异常捕获
 * Created by FanYanGen on 2019/4/17 15:00
 */
@ControllerAdvice
public class GlobalExceptionCatch {

    @Autowired
    private HttpServletRequest request;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception ex) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("Time", new Date());
        map.put("Url", request.getRequestURL());
        map.put("Uri", request.getRequestURI());
        map.put("HttpType", request.getMethod());
        if (ex instanceof BusinessException) {
            BusinessException be = (BusinessException) ex;
            return ExceptionResponse.create(be.getCode(), be.getMessage(), map);
        } else {
            return ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), map);
        }
    }

}
