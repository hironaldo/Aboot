package com.cheery.common;

import com.cheery.common.exception.BusinessException;
import com.cheery.common.exception.ExceptionResponse;
import com.google.common.collect.Maps;
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

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(HttpServletRequest request, Exception ex) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("Time", new Date());
        map.put("Url", request.getRequestURL());
        map.put("Uri", request.getRequestURI());
        map.put("Method", request.getMethod());
        if (ex instanceof BusinessException) {
            BusinessException be = (BusinessException) ex;
            return ExceptionResponse.create(be.getCode(), be.getMessage(), map);
        } else {
            return ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), map);
        }
    }

}
