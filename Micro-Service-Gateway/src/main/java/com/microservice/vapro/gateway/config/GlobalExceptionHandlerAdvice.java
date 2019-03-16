package com.microservice.vapro.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {
    private static final Logger log= LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String,Object> exceptionFound(Exception exception){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("Wrong Message:",exception.getMessage());
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        exception.printStackTrace();
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        return map;
    }
}
