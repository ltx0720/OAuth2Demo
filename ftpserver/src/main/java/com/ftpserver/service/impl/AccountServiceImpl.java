package com.ftpserver.service.impl;

import com.ftpserver.dao.AccountDao;
import com.ftpserver.pojo.Account;
import com.ftpserver.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ltx
 * @Date 16:31 2020/3/29
 */
@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    //先从redis中找
//    @Transactional
    @Override
    public Account getAccountByUsername(String username) {
        Account account = accountDao.getAccountByUsername(username);

        return account;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = getAccountByUsername(username);
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        account.setAuthorities(list);
        return account;
    }
}
