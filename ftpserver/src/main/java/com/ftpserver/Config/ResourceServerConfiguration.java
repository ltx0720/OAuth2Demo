package com.ftpserver.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * OAuth2 资源授权服务
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/ftptest/download").hasRole("TEACHER")
                .antMatchers("/ftptest/upload").hasRole("STUDENT")
                .antMatchers(HttpMethod.GET, "/ftptest/upload").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.GET, "/ftptest/upload").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST, "/ftptest/select").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.GET, "/ftptest/download").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('delete')")
                .anyRequest().authenticated()
                .and().cors() // 需要添加此配置项
                .and().csrf().disable();

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("file_api").stateless(true);
    }
}
