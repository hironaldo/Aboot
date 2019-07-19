package com.cheery.service;

import com.cheery.vo.SysLogVO;

import java.util.List;

/**
 * desc: 日志模块-业务逻辑层服务接口
 * Created by FanYanGen on 2019-05-20 11:00
 */
public interface LogService {

    /**
     * desc: 获取日志列表
     *
     * @return result list
     * @auther FanYanGen
     * @date 2019-05-20 19:20
     */
    List<SysLogVO> getLogList();

    /**
     * desc: 清除单条操作日志
     *
     * @param logId 日志ID
     * @return one result
     * @auther FanYanGen
     * @date 2019-06-10 14:52
     */
    int clearOneLog(String logId);

    /**
     * desc: 清除所有操作日志
     *
     * @return one result
     * @auther FanYanGen
     * @date 2019-06-10 14:35
     */
    int clearAllLogs();

}
