package com.microservice.valpro.resource01.controller;

import com.microservice.valpro.common.dto.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 23:55
 **/
@Controller
public class UserController {
    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/")
    public String getHome(){
        return "redirect:starter";
    }

    @ResponseBody
    @RequestMapping("/starter")
    public String getHomePage(){
        return "starter";
    }

    @RequestMapping("hello")
    public String hello(){
        return "/index/home";
    }

    @RequestMapping("index")
    public Mono<String> getLoginpage(){
        return Mono.just("/index/login");
    }

    @RequestMapping("/login")
    public Mono<String> processLogin(UserVo user){
        String username=user.getUsername();
        String password=user.getPassword();
        log.info(username+password);
        return Mono.just("/index/home");
    }

    @RequestMapping("/test")
    public Mono<String> test(){
        return Mono.just("/component/starter");
    }
}
