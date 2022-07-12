package com.anubis.core.service.user;

import com.anubis.core.dto.SignupRequest;
import com.anubis.core.entity.User;

public interface UserService {
    User create(SignupRequest signupRequest);
    User find(long userId);
    User findByUsername(String username);
}
