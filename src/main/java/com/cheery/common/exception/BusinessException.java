package com.cheery.common.exception;

import lombok.Getter;

/**
 * desc: 业务异常
 * Created by FanYanGen on 2019/4/18 15:16
 */
public class BusinessException extends RuntimeException {

    @Getter
    private Integer status;

    @Getter
    private Exception e;

    BusinessException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    BusinessException(String message, Exception e) {
        super(message);
        this.e = e;
    }

}
