package com.ftpserver.service;

import com.ftpserver.pojo.Account;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @Author ltx
 * @Date 16:30 2020/3/29
 */
@Service
public interface AccountService extends UserDetailsService {
    Account getAccountByUsername(String username);
}
