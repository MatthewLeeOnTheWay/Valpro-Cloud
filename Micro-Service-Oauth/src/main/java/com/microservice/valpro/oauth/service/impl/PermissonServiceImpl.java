package com.microservice.valpro.oauth.service.impl;

import com.microservice.valpro.common.entity.Result;
import com.microservice.valpro.oauth.dao.MenuDao;
import com.microservice.valpro.oauth.entity.SysMenu;
import com.microservice.valpro.oauth.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 04:41
 **/
@Service("permissionService")
public class PermissonServiceImpl implements PermissionService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public Result getPermissionsByRoleId(Integer roleId) {
        List list=menuDao.getPermissionsByRoleId(roleId);
        return Result.ok().setData(list);
    }
}
