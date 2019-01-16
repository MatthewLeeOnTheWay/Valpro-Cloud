package com.microservice.valpro.resource01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 23:55
 **/
@Controller
public class UserController {

    @RequestMapping("/")
    public String getHome(){
        return "redirect:starter";
    }

    @RequestMapping("/starter")
    public String getHomePage(){
        return "/starter";
    }
}
