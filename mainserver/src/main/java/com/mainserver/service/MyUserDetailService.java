package com.mainserver.service;

import com.mainserver.dao.UserMapper;
import com.mainserver.pojo.MyPasswordEncoder;
import com.mainserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ltx
 * @Date 21:14 2020/3/25
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userDao;
    @Autowired
    private MyPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        System.out.println(user.toString());
//        user.setPassword(encoder.encode(user.getPassword()));

        String roles = user.getRoles();
        String[] strings = roles.split(",");

        List<GrantedAuthority> list = new ArrayList<>();

        for (String role : strings){
            list.add(new SimpleGrantedAuthority(role));
        }

        user.setAuthorities(list);

        return user;
    }
}
