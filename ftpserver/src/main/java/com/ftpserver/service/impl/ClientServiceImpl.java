package com.ftpserver.service.impl;

import com.ftpserver.pojo.ClientDetail;
import com.ftpserver.service.ClientService;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author ltx
 * @Date 21:57 2020/3/28
 */
@Component
public class ClientServiceImpl implements ClientService {

    @Override
    public List<ClientDetail> getAllClients() {
        Set<String> set1 = new HashSet<>();
        set1.add("read");
        set1.add("write");

        Set<String> set2 = new HashSet<>();
        set2.add("password");
        set2.add("refresh_token");

        ClientDetail client = new ClientDetail("client", "pass",
                set1, set2);
        List<ClientDetail> detailList = Arrays.asList(client);
        return detailList;
    }

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        Set<String> set1 = new HashSet<>();
        set1.add("read");
        set1.add("write");

        Set<String> set2 = new HashSet<>();
        set2.add("password");
        set2.add("refresh_token");

        ClientDetail client = new ClientDetail("client", "pass", set1, set2);

        return client;
    }
}
