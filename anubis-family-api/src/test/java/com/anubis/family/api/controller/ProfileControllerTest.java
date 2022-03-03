package com.anubis.family.api.controller;

import com.anubis.core.dao.FamilyMemberRepo;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.family.api.model.User;
import com.anubis.family.api.service.family.FamilyMemberService;
import com.anubis.family.api.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfileControllerTest {

    @Mock
    UserService userService;

    @Mock
    FamilyMemberService familyMemberService;

    @InjectMocks
    ProfileController profileController;

    @Mock
    User user;

    @Mock
    FamilyMember familyMember;

    @BeforeEach
    public void setup() {
        when(user.getEmail()).thenReturn("email.address@host.com");
    }

    @Test
    public void getUserProfile() {
        when(userService.find(1)).thenReturn(user);
        when(familyMemberService.getFamilyMemberByEmail(user.getEmail())).thenReturn(familyMember);
        ResponseEntity<?> response = profileController.getUserProfile(1);
        Assertions.assertEquals(response, ResponseEntity.ok(familyMember));
    }

    @Test
    public void saveProfile() {}
}
