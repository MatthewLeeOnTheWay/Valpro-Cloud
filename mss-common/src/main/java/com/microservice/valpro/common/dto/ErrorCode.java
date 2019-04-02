package com.microservice.valpro.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @description: 错误信息
 * @author: Mr.Lee
 * @create: 2019-01-02 00:55
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorCode implements Serializable {
    public static final int OK=200;


    public static final int BAD_REQUEST=400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUNT = 404;

    public static final int MICRO_SERVICE_UNAVAILABLE = 40001;//微服务不可用

    public static final int SERVER_ERROR=500;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE=503;
}
