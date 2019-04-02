package com.microservice.valpro.oauth.service.impl;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.valpro.oauth.entity.SysUser;
import com.microservice.valpro.oauth.service.PermissionService;
import com.microservice.valpro.oauth.service.RoleService;
import com.microservice.valpro.oauth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户登录认证信息查询
 * @author Louis
 * @date Nov 20, 2018
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    Logger logger= LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserService sysUserService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @SuppressWarnings("unchecked")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.findByUsername(username).getData();
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        // 用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，决定是否可以调用接口
        /*Set<String> permissions = new HashSet<>();
        List<SysRole> list=roleService.getRoleByUserId(user.getId()).getData();
        for(SysRole role:list){
            int id=role.getId();
            List<String> listSet= (ArrayList<String>) permissionService.getPermissionsByRoleId(id).getData();
            permissions.addAll(listSet);
        }
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());*/
        List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
        /*List<String> roleList= (List<String>) roleService.getRoleByUserId(user.getId());
        if(roleList.size()>0){
            for (String roleName:roleList){
                authorities.add(new SimpleGrantedAuthority(roleName));
            }
        }*/
        User userDetail=new User(username, user.getPassword(),/*user.getSalt(),*/ authorities);
        try {
            logger.info(mapper.writeValueAsString(userDetail));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userDetail;
    }
}