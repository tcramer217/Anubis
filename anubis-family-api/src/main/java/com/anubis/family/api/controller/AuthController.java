package com.anubis.family.api.controller;

import com.anubis.core.dto.LoginRequest;
import com.anubis.core.dto.SignupRequest;
import com.anubis.family.api.model.response.MessageResponse;
import com.anubis.core.dto.UserInfoResponse;
import com.anubis.core.dao.RoleRepository;
import com.anubis.core.service.auth.AuthServiceImpl;
import com.anubis.core.service.user.UserServiceImpl;
import com.anubis.core.util.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    AuthServiceImpl authService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/signin")
    public ResponseEntity<UserInfoResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        UserInfoResponse response = getAuthService().authenticateUser(loginRequest);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, response.getJwt().toString()).body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        getUserService().create(signUpRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    public AuthServiceImpl getAuthService() {
        return authService;
    }

    public void setAuthService(AuthServiceImpl authService) {
        this.authService = authService;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
