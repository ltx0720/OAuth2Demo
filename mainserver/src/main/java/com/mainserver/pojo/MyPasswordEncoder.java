package com.mainserver.pojo;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author ltx
 * @Date 22:49 2020/3/25
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
