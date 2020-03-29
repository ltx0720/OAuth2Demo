package com.mainserver.Controller;

import com.mainserver.pojo.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ltx
 * @Date 17:42 2020/3/29
 */
@RestController
@RequestMapping("/file")
public class OAuth2Controller {

    //获取请求文件服务器的相关参数信息
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String getOAuth2Msg(HttpSession session){
        Map<String, String> map = new HashMap<>();
        SecurityContext ctx =
                (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        User user = (User)ctx.getAuthentication().getPrincipal();

        return user.toString();
    }
}
