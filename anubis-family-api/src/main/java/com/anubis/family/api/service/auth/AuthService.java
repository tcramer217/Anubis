package com.anubis.family.api.service.auth;

import com.anubis.family.api.model.request.LoginRequest;
import com.anubis.family.api.model.response.UserInfoResponse;

public interface AuthService {
    UserInfoResponse authenticateUser(LoginRequest request);
}
