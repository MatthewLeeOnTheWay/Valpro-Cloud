package com.microservice.valpro.oauth.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.valpro.common.entity.*;
import com.microservice.valpro.oauth.entity.SysMenu;
import com.microservice.valpro.oauth.entity.SysRole;
import com.microservice.valpro.oauth.entity.SysUser;
import com.microservice.valpro.oauth.service.PermissionService;
import com.microservice.valpro.oauth.service.RoleService;
import com.microservice.valpro.oauth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 02:14
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger=LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Result<SysUser> userResult = userService.findByUsername(username);
        if (userResult==null) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定

        Result<List<SysRole>> roleResult = roleService.getRoleByUserId(userResult.getData().getId());
        if (roleResult!=null){
            List<SysRole> roleList = roleResult.getData();
            for (SysRole role:roleList){
                //角色必须是ROLE_开头，可以在数据库中设置
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getValue());
                grantedAuthorities.add(grantedAuthority);
                //获取权限
                Result<List<SysMenu>> perResult  = permissionService.getPermissionsByRoleId(role.getId());
                if (perResult!=null){
                    List<SysMenu> permissionList = perResult.getData();
                    for (SysMenu menu:permissionList
                    ) {
                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                        grantedAuthorities.add(authority);
                    }
                }
            }
        }
        User user = new User(userResult.getData().getUsername(), userResult.getData().getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
