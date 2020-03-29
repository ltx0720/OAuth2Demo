package com.ftpserver.dao;

import com.ftpserver.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author ltx
 * @Date 16:28 2020/3/29
 */
@Mapper
public interface AccountDao {

    @Select("select * from account where username=#{username}")
    Account getAccountByUsername(String username);
}
