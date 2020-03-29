package com.mainserver.Filter;

import com.alibaba.fastjson.JSONArray;
import com.mainserver.Result.AjaxResult;
import com.mainserver.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ltx
 * @Date 19:48 2020/3/26
 *
 * 登录成功后的处理， 记录日志，写session
 */
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Value("${spring.security.loginType}")
    private String type;

    //登录成功后，可以把用户信息存入redis
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        //从session中拿用户名密码
        SecurityContext ctx =
                (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        ctx.getAuthentication().getPrincipal();

        //从SecurityContextHolder中拿用户名密码
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);



//        if ("json".equals(type)){
//            response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write(JSONArray.toJSONString(new AjaxResult<>(true, new Object())));
//        }else {
//            super.onAuthenticationSuccess(request, response, chain, authentication);
//        }
    }
}
