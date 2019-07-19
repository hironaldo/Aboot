package com.cheery.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * desc: API结果返回
 * Created by FanYanGen on 2019/4/17 14:18
 */
@Getter
@AllArgsConstructor
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ApiJson<T> {

    private Integer status;

    private String message;

    private T data;

    private ApiJson(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status.equals(ResultCode.SUCCESS.getStatus());
    }

    /**
     * desc: 根据数据影响行数来判断操作是否成功
     * 适用于 新增、修改、删除
     *
     * @param result 数据影响行数
     * @auther FanYanGen
     * @date 2019-05-21 20:50
     */
    public static <T> ApiJson<T> judgment(int result) {
        if (result > 0) {
            return new ApiJson<>(ResultCode.SUCCESS.getStatus(), ResultCode.SUCCESS.getDesc());
        } else {
            return new ApiJson<>(ResultCode.ERROR.getStatus(), ResultCode.ERROR.getDesc());
        }
    }

    /**
     * desc: 返回查询成功后的数据
     * 适用于 查询
     *
     * @param data 数据
     * @auther FanYanGen
     * @date 2019-05-21 20:51
     */
    public static <T> ApiJson<T> result(T data) {
        return new ApiJson<>(ResultCode.SUCCESS.getStatus(), ResultCode.SUCCESS.getDesc(), data);
    }

}