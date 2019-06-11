package com.cheery.service.impl;

import com.cheery.common.exception.NotFoundException;
import com.cheery.repository.LogRepository;
import com.cheery.service.LogService;
import com.cheery.util.BeanUtil;
import com.cheery.vo.SysLogVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * desc: 日志模块-业务逻辑层服务接口实现
 * Created by FanYanGen on 2019-05-20 19:22
 */
@Slf4j
@Transactional(rollbackFor = Throwable.class)
@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public List<SysLogVO> getLogList() {
        return BeanUtil.transformFromInBatch(logRepository.findAll(), SysLogVO.class);
    }

    @Override
    public int clearOneLog(String logId) {
        Assert.notNull(logId, "logId 不能为空");

        if (logRepository.checkDataIsExists(logId) < 1) {
            throw new NotFoundException("该数据不存在");
        }

        return logRepository.deleteByLogId(logId);
    }

    @Override
    public int clearAllLogs() {
        int result = 0;
        try {
            logRepository.deleteAll();
            result = 1;
        } catch (Exception e) {
            log.error("******* 操作失败 事务回滚 *******", e);
        }
        return result;
    }

}
