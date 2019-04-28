package com.cheery.common.exception;

import lombok.Getter;

/**
 * desc: 业务异常
 * Created by FanYanGen on 2019/4/18 15:16
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Getter
    private Integer code;

    BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
