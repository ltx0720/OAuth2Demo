//package com.ftpserver.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//
///**
// * @Author ltx
// * @Date 20:38 2020/3/29
// */
//@Configuration
//public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
//
//    // This is required for password grants, which we specify below as one of the
//    // {@literal authorizedGrantTypes()}.
//    @Autowired
//    AppConfig config;
//    @Autowired
//    AuthenticationManagerBuilder authenticationManager;
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
//            throws Exception {
//        endpoints.authenticationManager(new AuthenticationManager() {
//            @Override
//            public Authentication authenticate(Authentication authentication)
//                    throws AuthenticationException {
//                return authenticationManager.getOrBuild().authenticate(authentication);
//            }
//        });
//    }
//
//    // Client settings
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//        clients.inMemory().withClient(config.clientId)
//                .authorizedGrantTypes("password", "refresh_token")
//                .authorities("ROLE_USER").scopes("write")
//                .secret(config.clientSecret);
//    }
//}