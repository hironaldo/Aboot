package com.cheery.common.aop;

import com.cheery.common.annotation.SystemLog;
import com.cheery.entity.SysLog;
import com.cheery.repository.LogRepository;
import com.cheery.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;
import java.lang.reflect.Method;

/**
 * desc: 系统日志：切面处理类
 * Created by FanYanGen on 2019-05-20 11:25
 */
@Slf4j
@Component
@Aspect
public class SysLogAspect {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private HttpServletRequest request;

    private SysLog sysLog = new com.cheery.entity.SysLog();

    /**
     * 把切入点设置为自定义的注解
     */
    @Pointcut("@annotation(com.cheery.common.annotation.SystemLog)")
    public void logPointCut() {
    }

    @Transactional(rollbackFor = Throwable.class)
    @Before("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        try {
            sysLog.setLogId(UUIDUtil.snowFlakeUUID());
            sysLog.setUserId(0L);
            sysLog.setUserName("ronaldo");
            sysLog.setUserIp(request.getRemoteAddr());
            sysLog.setUserBrowser(request.getHeader("User-Agent"));
            sysLog.setUri(request.getRequestURI());
            sysLog.setUrl(request.getRequestURL().toString());
            sysLog.setDescription(descriptionExpression(joinPoint));
            sysLog.setParameter(Arrays.toString(joinPoint.getArgs()));
            sysLog.setClassName(joinPoint.getSignature().getDeclaringTypeName());
            sysLog.setMethod(joinPoint.getSignature().getName());
            sysLog.setHttpType(request.getMethod());
            sysLog.setUseTime(System.currentTimeMillis());
            logRepository.save(sysLog);
        } catch (Exception e) {
            log.error("===== 日志记录异常 =====");
            log.error("异常信息: {}", e.getMessage());
        }
    }

    /**
     * 获取具体方法上注解的描述内容
     */
    private String descriptionExpression(JoinPoint joinPoint) {
        Method currentMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
        SystemLog methodCache = AnnotationUtils.getAnnotation(currentMethod, SystemLog.class);
        return Objects.nonNull(methodCache) ? methodCache.value() : null;
    }

    /**
     * 设置方法请求时间
     */
    @AfterReturning(pointcut = "logPointCut()")
    private void interviewTime() {
        sysLog.setUseTime(System.currentTimeMillis() - sysLog.getUseTime());
    }

}
