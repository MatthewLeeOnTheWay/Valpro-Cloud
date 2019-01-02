package com.microservice.valpro.oauth.service;

import com.microservice.valpro.common.entity.Result;
import com.microservice.valpro.oauth.entity.SysMenu;

import java.util.List;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 04:40
 **/
public interface PermissionService {
    Result getPermissionsByRoleId(Integer roleId);
}
