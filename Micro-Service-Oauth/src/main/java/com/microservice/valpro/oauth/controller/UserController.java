package com.microservice.valpro.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 01:59
 **/
@RestController
public class UserController {

    @RequestMapping("/user")
    public Principal getUser(Principal user){
        return user;
    }
}
