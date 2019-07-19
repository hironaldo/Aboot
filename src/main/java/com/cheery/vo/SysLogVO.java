package com.cheery.vo;

import lombok.Data;

import java.util.Date;

/**
 * desc: 用户操作日志VO
 * Created by FanYanGen on 2019-05-20 11:00
 */
@Data
public class SysLogVO {

    private String logId;

    private Long userId;

    private String userName;

    private String userIp;

    private String userBrowser;

    private String description;

    private String className;

    private String method;

    private String httpType;

    private String parameter;

    private String uri;

    private String url;

    private Long useTime;

    private Date createTime;

}
