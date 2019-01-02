package com.microservice.valpro.oauth.controller;

import com.microservice.valpro.common.entity.Result;
import com.microservice.valpro.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: logout control
 * @author: Mr.Lee
 * @create: 2019-01-02 01:44
 **/
@RestController
public class LogoutController {
    @Autowired
    private ConsumerTokenServices services;

    @RequestMapping("/exit")
    public @ResponseBody
    Result revokeToken(String access_token){
        Result msg = new Result();
        if (services.revokeToken(access_token)){
            msg.setCode(StatusCode.SUCCESS_CODE);
            msg.setMsg("注销成功");
        }else {
            msg.setCode(StatusCode.FAILURE_CODE);
            msg.setMsg("注销失败");
        }
        return msg;
    }
}
