package com.cheery.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * desc: 抽离各实体公共字段组成父实体 @MappedSuperclass标注的类将不会识别为一个实体
 * Created by FanYanGen on 2019/4/17 15:22
 */
@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "del_flag")
    private Integer delFlag = 0;

    @CreatedDate
    @Column(name = "create_time")
    @JSONField(serialize = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @LastModifiedDate
    @Column(name = "update_time")
    @JSONField(serialize = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
