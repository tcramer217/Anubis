package com.anubis.family.api.controller;

import com.anubis.core.dao.FamilyMemberRepo;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.family.api.model.User;
import com.anubis.family.api.model.response.MessageResponse;
import com.anubis.family.api.repo.UserRepository;
import com.anubis.family.api.service.user.UserService;
import com.anubis.family.api.util.JwtUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/profile")
@PreAuthorize("hasRole('USER')")
public class ProfileController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private FamilyMemberRepo familyMemberRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserProfile(@PathVariable Integer userId, HttpServletRequest request) {
        String jwt = getJwtUtil().parseJwt(request);
        String username = getJwtUtil().getUserNameFromJwtToken(jwt);
        User userAccount = getUserService().findByUsername(username);

        if (userAccount == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Unable to find user for your account."));
        }

        FamilyMember memberProfile = getFamilyMemberRepo().findFamilyMemberByEmail(userAccount.getEmail());

        return ResponseEntity.ok(memberProfile);
    }

    public JwtUtil getJwtUtil() {
        return jwtUtil;
    }

    public void setJwtUtil(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public FamilyMemberRepo getFamilyMemberRepo() {
        return familyMemberRepo;
    }

    public void setFamilyMemberRepo(FamilyMemberRepo familyMemberRepo) {
        this.familyMemberRepo = familyMemberRepo;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
