package com.microservice.valpro.oauth.service.impl;

import com.microservice.valpro.common.dto.Result;
import com.microservice.valpro.oauth.dao.RoleDao;
import com.microservice.valpro.oauth.entity.SysRole;
import com.microservice.valpro.oauth.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 02:46
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public Result<List<SysRole>> getRoleByUserId(Integer userId) {
        List<SysRole> role=roleDao.getRoleByUserId(userId);
        return Result.ok().setData(role);
    }
}
