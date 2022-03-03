package com.anubis.family.api.controller;

import com.anubis.core.entity.family.FamilyMember;
import com.anubis.family.api.model.request.LoginRequest;
import com.anubis.family.api.model.response.UserInfoResponse;
import com.anubis.family.api.service.family.FamilyMemberService;
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

import java.util.Arrays;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FamilyControllerTest {

    @Mock
    FamilyMemberService familyMemberService;

    @InjectMocks
    FamilyController familyController;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void getFamilyMembers() {
        FamilyMember familyMember = new FamilyMember();
        when(familyMemberService.getFamilyMembersByFamilyId(1L)).thenReturn(Arrays.asList(familyMember));

        familyController.getFamilyMembers(1L);
        verify(familyMemberService).getFamilyMembersByFamilyId(1L);
    }
}
