package com.cheery.common.exception;

/**
 * desc: BeanUtils异常
 * Created by FanYanGen on 2019-06-06 11:21
 */
public class BeanUtilsException extends BusinessException {

    public BeanUtilsException(String message, Exception e) {
        super(message, e);
    }

}
