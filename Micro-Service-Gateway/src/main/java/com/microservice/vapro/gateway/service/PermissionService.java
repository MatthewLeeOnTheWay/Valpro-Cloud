package com.microservice.vapro.gateway.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 01:12
 **/
public interface PermissionService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
