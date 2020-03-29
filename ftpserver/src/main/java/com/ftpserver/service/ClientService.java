package com.ftpserver.service;

import com.ftpserver.pojo.ClientDetail;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ltx
 * @Date 21:54 2020/3/28
 */
@Service
public interface ClientService extends ClientDetailsService {

    List<ClientDetail> getAllClients();
}
