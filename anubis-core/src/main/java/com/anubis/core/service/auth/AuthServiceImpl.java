package com.anubis.core.service.auth;

import com.anubis.core.dto.LoginRequest;
import com.anubis.core.dto.UserInfoResponse;
import com.anubis.core.exception.UsernamePasswordAuthenticationException;
import com.anubis.core.util.JwtHelper;
import com.anubis.core.service.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtHelper jwtHelper;

    @Override
    public UserInfoResponse authenticateUser(LoginRequest loginRequest)
            throws UsernamePasswordAuthenticationException {
        Authentication authentication;
        try {
            authentication = getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    ));
        } catch (AuthenticationException authEx) {
            throw new UsernamePasswordAuthenticationException();
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie jwtCookie = getJwtUtil().generateJwtCookie(userDetails);
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        UserInfoResponse response = new UserInfoResponse();
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setEmail(userDetails.getEmail());
        response.setRoles(new HashSet<>(roles));
        response.setJwt(jwtCookie);
        response.setAccessToken(jwtCookie.getValue());

        return response;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public JwtHelper getJwtUtil() {
        return jwtHelper;
    }

    public void setJwtUtil(JwtHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }
}
