package com.anubis.core.service.auth;


import com.anubis.core.dto.LoginRequest;
import com.anubis.core.dto.UserInfoResponse;

public interface AuthService {
    UserInfoResponse authenticateUser(LoginRequest request);
}
