package com.microservice.valpro.oauth.dao;

import com.microservice.valpro.oauth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 04:26
 **/
@Repository
public interface UserDao extends JpaRepository<SysUser,Integer> {

    SysUser findByUsername(String userName);
}
