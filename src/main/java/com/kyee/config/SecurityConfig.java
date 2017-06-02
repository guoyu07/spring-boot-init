package com.kyee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 自定义配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()
                .antMatchers("/users/**").hasRole("USER")
                .antMatchers("/admins/**").hasRole("ADMIN")
                .and()
            .formLogin() //基于form表单的验证
                .loginPage("/login").failureUrl("/login-error") //自定义登录界面
                .and()
            .exceptionHandling().accessDeniedPage("/403"); //处理异常，拒绝访问就重定向访问到403页面
        http.logout().logoutSuccessUrl("/");
    }

    /**
     * 用户信息管理
     */
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(); // 在内存中存放用户信息
        manager.createUser(User.withUsername("wangshi").password("123456").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("123456").roles("USER","ADMIN").build());
        return manager;
    }

    /**
     * 认证信息管理
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService());
    }
}
