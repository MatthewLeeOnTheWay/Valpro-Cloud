package com.microservice.valpro.oauth.service;

import com.microservice.valpro.common.entity.Result;
import com.microservice.valpro.oauth.entity.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 02:04
 **/

/*@FeignClient(name = "",fallback = UserServiceFallbackImpl.class)*/
public interface UserService {

    @GetMapping("user/findByUsername/{username}")
    Result<SysUser> findByUsername(@PathVariable("username") String username);
}
