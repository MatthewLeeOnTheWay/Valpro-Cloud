package com.microservice.valpro.common.service;

import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 01:12
 **/
public interface PermissionService {
    boolean hasPermission(HttpRequest request, Authentication authentication);
}
