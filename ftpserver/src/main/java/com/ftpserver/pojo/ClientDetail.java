package com.ftpserver.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

/**
 * @Author ltx
 * @Date 21:51 2020/3/28
 *
 * 客户端信息
 */
@Data
public class ClientDetail implements ClientDetails {
    private String clientId;
    private String client_Secret;
    private Set<String> scopes;
    private Set<String> authorizedGrantTypes;

    public ClientDetail(String clientId, String client_Secret, Set<String> scopes, Set<String> authorizedGrantTypes) {
        this.clientId = clientId;
        this.client_Secret = client_Secret;
        this.scopes = scopes;
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    @Override
    public Set<String> getResourceIds() {
        Set<String> set = new HashSet<>();
        set.add("file_api");
        return set;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return this.client_Secret;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return this.scopes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        list.add(authority);
        return list;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return null;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 60 * 60;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
