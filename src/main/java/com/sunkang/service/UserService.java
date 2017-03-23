package com.sunkang.service;

import com.sunkang.dao.UserRepository;
import com.sunkang.entity.Role;
import com.sunkang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by changxiang on 2017-03-17.
 * 用户操作的服务类,需要继承UserDetailsService
 *
 * 自定义验证
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    /**
     * 根据用户名加载校验用户，并且查处用户权限
     *
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
//        由于我们用户实现了userdetails接口，所以与安全框架的用户通用
        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
        /*根据用户名获得权限并且放入grantedAuthorities*/
        List<Role> roles=userRepository.findRoleByUsername(s);
        for(Role role:roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }

}
