package com.microservice.valpro.oauth.service.impl;

import com.microservice.valpro.common.entity.Result;
import com.microservice.valpro.oauth.dao.UserDao;
import com.microservice.valpro.oauth.entity.SysUser;
import com.microservice.valpro.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 02:11
 **/

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Result findByUsername(String username) {
        SysUser user=userDao.findByUsername(username);
        return Result.ok().setData(user);
    }
}
