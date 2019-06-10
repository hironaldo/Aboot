package com.cheery.entity;

import com.cheery.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * desc: 用户操作记录日志实体
 * Created by FanYanGen on 2019-05-20 10:59
 */
@Data
@Entity
@Table(name = "logs")
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class SysLog extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7890535036510161881L;

    @Column(name = "log_id")
    private String logId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_ip")
    private String userIp;

    @Column(name = "user_browser")
    private String userBrowser;

    @Column(name = "description")
    private String description;

    @Column(name = "class")
    private String className;

    @Column(name = "method")
    private String method;

    @Column(name = "httpType")
    private String httpType;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "uri")
    private String uri;

    @Column(name = "url")
    private String url;

    @Column(name = "use_time")
    private Long useTime;

}
