package com.anubis.family.api.controller;

import com.anubis.family.api.model.request.LoginRequest;
import com.anubis.family.api.model.request.SignupRequest;
import com.anubis.family.api.model.response.MessageResponse;
import com.anubis.family.api.model.response.UserInfoResponse;
import com.anubis.family.api.repo.RoleRepository;
import com.anubis.family.api.repo.UserRepository;
import com.anubis.family.api.service.auth.AuthServiceImpl;
import com.anubis.family.api.service.user.UserServiceImpl;
import com.anubis.family.api.util.JwtUtil;
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
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

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
        ResponseEntity<?> response;
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
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
