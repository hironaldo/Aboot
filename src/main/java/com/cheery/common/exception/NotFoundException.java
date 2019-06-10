package com.cheery.common.exception;

import com.cheery.common.ResultCode;

/**
 * desc: 数据未找到异常
 * Created by FanYanGen on 2019/4/18 15:13
 */
public class NotFoundException extends BusinessException {

    public NotFoundException(String message) {
        super(ResultCode.NO_COMPLETE_ARGUMENT.getStatus(), message);
    }

}
