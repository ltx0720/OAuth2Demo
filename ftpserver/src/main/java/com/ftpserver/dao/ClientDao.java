package com.ftpserver.dao;

import com.ftpserver.pojo.ClientDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author ltx
 * @Date 21:49 2020/3/28
 *
 * 从数据库中查询 Client 信息
 */
@Mapper
public interface ClientDao {

    @Select("select * from client")
    List<ClientDetail> getAllClients();
}
