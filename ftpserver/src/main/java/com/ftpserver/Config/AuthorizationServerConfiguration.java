package com.ftpserver.Config;

import com.ftpserver.service.AccountService;
import com.ftpserver.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * OAuth2 认证服务
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfiguration  extends AuthorizationServerConfigurerAdapter {
    //Oauth2 认证服务
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;

    //客户端信息查询
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientService);
    }

    //检测Token策略
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许表单认证
        security.allowFormAuthenticationForClients();

        //允许 check_token 访问
        security.checkTokenAccess("permitAll()");
    }

    //oauth 主配置信息
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //用于验证用户的Service
        endpoints.userDetailsService(accountService);

        //刷新令牌时需要的认证管理和用户信息来源
        endpoints.authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
//        endpoints.authenticationManager(authenticationManager);
    }

}
