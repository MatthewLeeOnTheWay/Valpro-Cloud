package com.microservice.valpro.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 01:58
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusCode implements Serializable {
    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "操作成功";

    public static final int FAILURE_CODE = 201;
    public static final String FAILURE_MSG = "操作失败";
}
