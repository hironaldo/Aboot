package com.cheery.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * desc: API响应编码
 * Created by FanYanGen on 2019/4/17 14:10
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    /**
     * 10001   操作成功
     * 10002   操作异常
     * <p>
     * 50001   系统异常
     * 50002   token无效或过期
     * 50003   未登录
     * 50004   没有访问权限
     * <p>
     * 70001   数据不完整(参数缺失 / 参数溢出)
     * 70002   数据校验失败 必传字段未传
     * 70003   非法数值
     * <p>
     * 80001   主键冲突
     **/

    SUCCESS(10001, "SUCCESS【 操作成功\uD83D\uDE00 】"),

    ERROR(10002, "ERROR【 操作异常\uD83D\uDE05 】"),

    SYSTEM_EXCEPTION(50001, "SYSTEM_EXCEPTION【 系统异常\uD83D\uDE2D 】"),

    ERROR_TOKEN(50002, "ERROR_TOKEN【 身份令牌无效或过期\uD83D\uDE25 】"),

    NO_LOGIN(50003, "NO_LOGIN【 未登录\uD83D\uDE2F 】"),

    NO_ACCESS_RIGHT(50004, "NO_ACCESS_RIGHT【 没有访问权限\uD83D\uDE1F 】"),

    NO_COMPLETE_ARGUMENT(70001, "NO_COMPLETE_ARGUMENT【 参数缺失 / 参数溢出\uD83D\uDE23 】"),

    CHECK_FAILURE_ARGUMENT(70002, "CHECK_FAILURE_ARGUMENT【 数据校验失败\uD83D\uDE23 】"),

    ILLEGAL_ARGUMENT(70003, "ILLEGAL_ARGUMENT【 非法参数\uD83D\uDE23 】"),

    DATA_DUPLICATION(80001, "DATA_DUPLICATION【 主键冲突\uD83D\uDE23 】");

    private final Integer status;

    private final String desc;

}