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

    public static <T> ApiJson<T> error() {
        return new ApiJson<>(ResultCode.ERROR.getStatus(), ResultCode.ERROR.getDesc());
    }

    public static <T> ApiJson<T> error(String message) {
        return new ApiJson<>(ResultCode.ERROR.getStatus(), message);
    }

    public static <T> ApiJson<T> success() {
        return new ApiJson<>(ResultCode.SUCCESS.getStatus(), ResultCode.SUCCESS.getDesc());
    }

    public static <T> ApiJson<T> success(T data) {
        return new ApiJson<>(ResultCode.SUCCESS.getStatus(), ResultCode.SUCCESS.getDesc(), data);
    }

}