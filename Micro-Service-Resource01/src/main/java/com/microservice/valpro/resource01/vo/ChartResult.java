package com.microservice.valpro.resource01.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-03-05 18:37
 **/

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChartResult {
    private String name;
    private int value;
    private String decription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public ChartResult(int value) {
        this.value = value;
    }

    public ChartResult() {
    }
}
