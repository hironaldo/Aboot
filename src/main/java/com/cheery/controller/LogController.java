package com.cheery.controller;

import com.cheery.common.ApiJson;
import com.cheery.common.annotation.SystemLog;
import com.cheery.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * desc: 日志模块-控制器
 * Created by FanYanGen on 2019/4/18 13:59
 */
@Api(tags = "SIU-日志模块")
@RequestMapping("/api/logs")
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @SystemLog("获取用户日志列表")
    @ApiOperation(value = "获取用户操作日志列表", httpMethod = "GET")
    @GetMapping
    public ApiJson logList() {
        return ApiJson.result(logService.getLogList());
    }

    @SystemLog("清除单条操作日志")
    @ApiOperation(value = "清除单条操作日志", httpMethod = "DELETE")
    @ApiImplicitParam(name = "logId", value = "日志主键ID", dataType = "String", paramType = "path", required = true)
    @DeleteMapping("/{logId}")
    public ApiJson clearOneLog(@PathVariable String logId) {
        return ApiJson.judgment(logService.clearOneLog(logId));
    }

    @SystemLog("清除所有操作日志")
    @ApiOperation(value = "清除所有操作日志", httpMethod = "DELETE")
    @DeleteMapping
    public ApiJson clearAllLogs() {
        return ApiJson.judgment(logService.clearAllLogs());
    }

}
