package com.microservice.valpro.oauth.service;

import com.microservice.valpro.common.entity.Result;
import com.microservice.valpro.oauth.entity.SysRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 02:44
 **/
/*@FeignClient(name = "",fallback = RoleServiceImpl.class)*/
public interface RoleService {
//    @GetMapping("role/getRoleByUserId/{userId}")
    Result<List<SysRole>> getRoleByUserId(@PathVariable("userId") Integer userId);
}
