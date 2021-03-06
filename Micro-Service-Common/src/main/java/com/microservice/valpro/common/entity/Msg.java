package com.microservice.valpro.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @description: 消息实体类
 * @author: Mr.Lee
 * @create: 2019-01-02 00:53
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Msg<T> implements Serializable {
    private static final long serialVersionUID = -1177183613782210351L;
    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
