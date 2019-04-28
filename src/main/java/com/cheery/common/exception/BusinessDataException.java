package com.cheery.common.exception;

/**
 * desc: 数据校验异常
 * Created by FanYanGen on 2019/4/18 15:13
 */
public class BusinessDataException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public BusinessDataException(Integer code, String message) {
        super(code, message);
    }

}
