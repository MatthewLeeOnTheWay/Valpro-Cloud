package com.microservice.vapro.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-02-15 10:30
 **/
@RestController
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "ljx-gateway";
    }
}
