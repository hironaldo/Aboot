package com.cheery.common.annotation;

import java.lang.annotation.*;

/**
 * desc: 记录用户操作日志-自定义注解
 * <p>
 * Target({ElementType.METHOD, ElementType.TYPE}) - 表示这个注解只能作用在方法上
 * Retention(RetentionPolicy.RUNTIME) - 表示这是一个运行时注解
 * Inherited 表示这个注解可以被子类继承
 * Documented 表示当执行javadoc的时候，本注解会生成相关文档
 * </p>
 * Created by FanYanGen on 2019-05-20 11:03
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Operation {

    String value() default "";

}
