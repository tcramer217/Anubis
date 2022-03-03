package com.anubis.family.api.controller;

import com.anubis.core.dao.FamilyMemberRepo;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.family.api.model.User;
import com.anubis.family.api.model.response.MessageResponse;
import com.anubis.family.api.service.family.FamilyMemberService;
import com.anubis.family.api.service.user.UserService;
import com.anubis.family.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/profile")
@PreAuthorize("hasRole('USER')")
public class ProfileController {

    private FamilyMemberService familyMemberService;
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserProfile(@PathVariable Integer userId) {
        User userAccount = getUserService().find(userId.longValue());
        if (userAccount == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Unable to find user for your account."));
        }
        FamilyMember memberProfile = getFamilyMemberService().getFamilyMemberByEmail(userAccount.getEmail());
        return ResponseEntity.ok(memberProfile);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProfile(@RequestBody FamilyMember familyMember) {
        FamilyMember member = getFamilyMemberService().save(familyMember);
        return ResponseEntity.ok(member);
    }

    public FamilyMemberService getFamilyMemberService() {
        return familyMemberService;
    }

    @Autowired
    public void setFamilyMemberService(FamilyMemberService familyMemberService) {
        this.familyMemberService = familyMemberService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
