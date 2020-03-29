package com.mainserver.SecurityConfig;

import com.mainserver.pojo.MyPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ltx
 * @Date 17:19 2020/3/29
 */
@Configuration
public class BeanConfig {

    @Bean
    MyPasswordEncoder myPasswordEncoder(){
        return new MyPasswordEncoder();
    }
}
