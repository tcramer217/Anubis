package com.anubis.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.ResponseCookie;

import javax.persistence.Transient;
import java.util.Set;

public class UserInfoResponse {
    private long id;
    private String username;
    private String email;
    private Set<String> roles;

    @Transient
    private String tokenType = "Bearer";

    @Transient
    private String accessToken;

    @Transient
    @JsonIgnore
    private ResponseCookie jwt;

    public UserInfoResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public ResponseCookie getJwt() {
        return jwt;
    }

    public void setJwt(ResponseCookie jwt) {
        this.jwt = jwt;
    }
}
