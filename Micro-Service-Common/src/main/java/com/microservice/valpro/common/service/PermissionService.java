package com.microservice.valpro.common.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.reactive.function.server.ServerRequest;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 01:12
 **/
public interface PermissionService {
    boolean hasPermission(ServerRequest request, Authentication authentication);
}
