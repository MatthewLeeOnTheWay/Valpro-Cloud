package com.microservice.valpro.oauth.dao;

import com.microservice.valpro.oauth.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 04:29
 **/
@Repository
public interface RoleDao extends JpaRepository<SysRole,Integer> {

    @Query(value = "select role.* from sys_role role,sys_user_role ur where role.id=ur.role_id and ur.user_id=#{userId}",nativeQuery = true)
    List<SysRole> getRoleByUserId(Integer userId);
}
