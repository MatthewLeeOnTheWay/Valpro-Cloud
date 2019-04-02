package com.microservice.valpro.resource01.controller;



import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 23:55
 **/
@RestController
public class UserController {
    @GetMapping("/resource")
    public String resource(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Resource accessed by %s (sub)", jwt.getSubject());
    }
}
