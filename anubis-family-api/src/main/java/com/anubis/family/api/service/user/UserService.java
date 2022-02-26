package com.anubis.family.api.service.user;

import com.anubis.family.api.model.User;
import com.anubis.family.api.model.request.SignupRequest;

public interface UserService {
    User create(SignupRequest signupRequest);
    User find(long userId);
    User findByUsername(String username);
}
