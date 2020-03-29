package com.mainserver.Filter;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mainserver.Result.AjaxResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ltx
 * @Date 20:13 2020/3/26
 */
@Component
public class LoginFailHandler extends SimpleUrlAuthenticationFailureHandler {
    @Value("${spring.security.loginType}")
    private String type;

    private static ObjectMapper mapper = new ObjectMapper();

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        if ("json".equals(type)){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSONArray.toJSONString(new AjaxResult<>(false, new Object())));
//        }else {
//            super.onAuthenticationFailure(request, response, exception);
//
//        }
    }
}
