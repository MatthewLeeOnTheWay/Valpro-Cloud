package com.microservice.vapro.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-02-15 10:30
 **/

@Controller
public class IndexController {
    @ResponseBody
    @RequestMapping("/")
    public String index(){
        return "ljx-gateway";
    }

    @RequestMapping("/login")
    public String getPath(){
        return "redirect: /uaa/login";
    }
}
