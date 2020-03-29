package com.mainserver.dao;

import com.mainserver.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author ltx
 * @Date 21:13 2020/3/25
 */
@Mapper
public interface UserMapper {

    @Select("select * from users where username=#{username}")
    @Results(value = {
            @Result(column = "role", property = "roles"),
            @Result(column = "enabled", property = "enable")
    })
    User getUserByName(String username);
}
