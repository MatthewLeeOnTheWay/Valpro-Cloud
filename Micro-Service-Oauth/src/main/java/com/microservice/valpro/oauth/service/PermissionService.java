package com.microservice.valpro.oauth.service;

import com.microservice.valpro.common.dto.Result;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 04:40
 **/
public interface PermissionService {
    Result getPermissionsByRoleId(Integer roleId);
}
