package com.microservice.valpro.oauth.dao;

import com.microservice.valpro.oauth.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 04:31
 **/
@Repository
public interface MenuDao extends JpaRepository<SysMenu,Integer>{
   @Query(value = "select menu.* from sys_menu menu,sys_privilege p where menu.id=p.menu_id and p.role_id=:roleId",nativeQuery = true)
   List<SysMenu> getPermissionsByRoleId(@Param("roleId") Integer roleId);
}
