package com.anubis.family.api.controller;

import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.service.family.FamilyMemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
