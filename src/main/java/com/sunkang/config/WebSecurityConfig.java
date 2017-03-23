package com.sunkang.config;

import com.sunkang.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by changxiang on 2017-03-17.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * 注册
     * @return
     */
    @Bean
    UserService userService(){
        return new UserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //添加自定义的认证
        auth.userDetailsService(userService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制登录和注销行为
        http
//                .csrf().disable()// 去掉csrf验证，如果不去掉的话，前台表单必须要带上csrf参数,但是用thymeleaf好像可以不用带 注销和登录都需要
                .authorizeRequests().anyRequest().authenticated()//认证之后才能访问
//                .antMatchers("/","mylogin").permitAll()
//                .anyRequest().permitAll()
        .and().formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()//登录请求可以任意访问
         .and().logout()
                .logoutUrl("/logout")//退出登录
                .logoutSuccessUrl("/login?logout")//退出成功后跳转页面,默认为login?logout
                .permitAll()        //注销请求也可以任意访问
                .invalidateHttpSession(true)//退出删除session
        .and().sessionManagement().maximumSessions(1)
        ;
    }
}
