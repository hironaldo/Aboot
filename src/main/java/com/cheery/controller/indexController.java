package com.cheery.controller;

import com.cheery.common.ApiJson;
import com.cheery.common.ResultCode;
import com.cheery.common.exception.BusinessDataException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 * Created by FanYanGen on 2019/4/18 13:59
 */
@RestController
public class indexController {

    @RequestMapping("/{id}")
    public ApiJson<?> index(@PathVariable Integer id) {
        if (1 == id) {
            return ApiJson.success();
        } else if (2 == id) {
            return ApiJson.success("123456789....");
        } else if (3 == id) {
            return ApiJson.error();
        }
        throw new BusinessDataException(ResultCode.DATA_DUPLICATION.getStatus(), ResultCode.DATA_DUPLICATION.getDesc());
    }

}
