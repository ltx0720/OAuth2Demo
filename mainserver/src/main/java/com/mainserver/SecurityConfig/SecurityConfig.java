package com.mainserver.SecurityConfig;

import com.mainserver.Filter.LoginFailHandler;
import com.mainserver.Filter.LoginSuccessHandler;
import com.mainserver.pojo.MyPasswordEncoder;
import com.mainserver.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @Author ltx
 * @Date 23:14 2020/3/22
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService service;
    @Resource
    private LoginSuccessHandler loginSuccessHandler;
    @Resource
    private LoginFailHandler loginFailHandler;
    @Autowired
    private MyPasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure");
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/try-login", "/test").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/try-login")
                .loginProcessingUrl("/authentication/form")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailHandler)
                .defaultSuccessUrl("/index")
                .and()
                .rememberMe().userDetailsService(service)
        .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
        auth.jdbcAuthentication().passwordEncoder(encoder);
    }


}
