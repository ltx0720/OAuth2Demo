package com.mainserver.Controller;

import com.mainserver.dao.UserMapper;
import com.mainserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author ltx
 * @Date 17:23 2020/3/22
 */
@Controller
public class testController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping("/test")
    @ResponseBody
    public String testt(){
        User user = mapper.getUserByName("user");
        return user.toString();
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/user")
    public String index1(){
        return "user";
    }

    @RequestMapping("/try-login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(HttpSession session){
        return "admin";
    }
}
