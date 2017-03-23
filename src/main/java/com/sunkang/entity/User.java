package com.sunkang.entity;

import com.sunkang.dao.UserRepository;
import com.sunkang.service.UserService;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by changxiang on 2017-03-16.
 * 用户
 */
//implements UserDetails该方法比较适合jpa，现在用mybatis，将查询放入权限放在userservise类里面
public class User {

    /**
     * 注册
     * @return
     */
    @Bean
    UserService userService(){
        return new UserService();
    }

    private String id;

    private String username;

    private String password;

    private List<Role> roles;//角色

    /**
     * 获得该用户的权限
     * @return
     */
    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
        *//*将用户的角色作为权限*//*
        List<Role> roles=this.getRoles();
        for(Role role:roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }*/

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
