package com.anubis.family.api.service.user;

import com.anubis.family.api.exception.RoleNotFoundException;
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
        return getUserRepository().save(user);
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

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
