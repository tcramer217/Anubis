package com.anubis.family.api.service.user;

import com.anubis.core.dao.FamilyMemberRepo;
import com.anubis.core.dao.FamilyRepo;
import com.anubis.core.entity.family.Family;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.exception.RoleNotFoundException;
import com.anubis.family.api.model.Role;
import com.anubis.family.api.model.Roles;
import com.anubis.family.api.model.User;
import com.anubis.family.api.model.request.SignupRequest;
import com.anubis.family.api.repo.RoleRepository;
import com.anubis.family.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    FamilyRepo familyRepo;

    @Autowired
    FamilyMemberRepo familyMemberRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User create(SignupRequest signUpRequest) {
        if (getUserRepository().existsByUsername(signUpRequest.getUsername())) {
            throw new UsernameNotFoundException("Username Already Exists.");
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (getUserRepository().existsByEmail(signUpRequest.getEmail())) {
            throw new UsernameNotFoundException("Email Address Already Exists.");
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = getRole(Roles.ROLE_USER);
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                Role roleToAdd;
                switch (Roles.findRole(role)) {
                    case ROLE_ADMINISTRATOR:
                        roleToAdd = getRole(Roles.ROLE_ADMINISTRATOR);
                        break;
                    case ROLE_MODERATOR:
                        roleToAdd = getRole(Roles.ROLE_MODERATOR);
                        break;
                    case ROLE_CHILD:
                        roleToAdd = getRole(Roles.ROLE_CHILD);
                        break;
                    default:
                        roleToAdd = getRole(Roles.ROLE_USER);
                        break;
                }
                roles.add(roleToAdd);
            });
        }
        user.setRoles(roles);
        // setup initial profile info
        // TODO : Need to get initial family name somehow,Add to prfile setup page for FAMILY_ADMIN role
        User persistedUser = getUserRepository().save(user);
        Family newFamily = new Family("New Family");
        Family persistedFamily = getFamilyRepo().save(newFamily);
        FamilyMember newFamilyMember = new FamilyMember(null, null, persistedUser.getEmail(), persistedFamily.getId());
        getFamilyMemberRepo().save(newFamilyMember);
        return persistedUser;
    }

    @Override
    public User find(long userId) {
        return getUserRepository().findById(userId).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return getUserRepository().findByUsername(username).orElse(null);
    }

    protected Role getRole(Roles role) {
        return getRoleRepository().findByName(role).orElseThrow(RoleNotFoundException::new);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public FamilyRepo getFamilyRepo() {
        return familyRepo;
    }

    public void setFamilyRepo(FamilyRepo familyRepo) {
        this.familyRepo = familyRepo;
    }

    public FamilyMemberRepo getFamilyMemberRepo() {
        return familyMemberRepo;
    }

    public void setFamilyMemberRepo(FamilyMemberRepo familyMemberRepo) {
        this.familyMemberRepo = familyMemberRepo;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
