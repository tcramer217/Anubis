package com.anubis.family.api.controller;

import com.anubis.family.api.exception.UsernamePasswordAuthenticationException;
import com.anubis.family.api.model.User;
import com.anubis.family.api.model.request.LoginRequest;
import com.anubis.family.api.model.request.SignupRequest;
import com.anubis.family.api.model.response.UserInfoResponse;
import com.anubis.family.api.service.auth.AuthServiceImpl;
import com.anubis.family.api.service.user.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    UserServiceImpl userService;

    @Mock
    AuthServiceImpl authService;

    @InjectMocks
    AuthController authController;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void authenticateUser() {
        LoginRequest request = mock(LoginRequest.class);
        UserInfoResponse response = mock(UserInfoResponse.class);
        ResponseCookie responseCookie = ResponseCookie.from("key", "value").build();
        when(response.getJwt()).thenReturn(responseCookie);
        when(authService.authenticateUser(request)).thenReturn(response);

        ResponseEntity<UserInfoResponse> result = authController.authenticateUser(request);
        Assertions.assertEquals(result.getBody().getJwt().toString(), "key=value");
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void authenticateUser_usernamePasswordException() {
        LoginRequest request = mock(LoginRequest.class);
        when(authService.authenticateUser(request)).thenThrow(UsernamePasswordAuthenticationException.class);

        Assertions.assertThrows(UsernamePasswordAuthenticationException.class, () -> {
            authController.authenticateUser(request);
        });
    }

    @Test
    public void registerUser() {
        SignupRequest request = mock(SignupRequest.class);
        User user = mock(User.class);
        when(userService.create(request)).thenReturn(user);
        ResponseEntity<?> response = authController.registerUser(request);
        Assertions.assertNotNull(response);
    }

    @Test
    public void registerUser_usernameExists() {
        SignupRequest request = mock(SignupRequest.class);
        when(userService.create(request)).thenThrow(UsernameNotFoundException.class);
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            authController.registerUser(request);
        });
    }

    @Test
    public void registerUser_emailExists() {
        SignupRequest request = mock(SignupRequest.class);
        when(userService.create(request)).thenThrow(UsernameNotFoundException.class);
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            authController.registerUser(request);
        });
    }

}
