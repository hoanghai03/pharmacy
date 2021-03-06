package io.hoanghai.pharmacy.service;

import io.hoanghai.pharmacy.model.Role;
import io.hoanghai.pharmacy.model.User;
import io.hoanghai.pharmacy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("principalService")
public class PrincipalService {
    private final UserRepository userRepository;

    @Autowired
    public PrincipalService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) return null;
        return userRepository.findByEmail(auth.getName());
    }

    public boolean hasRole(String roleName) {
        User user = getUser();
        for (Role role : user.getRoles())
            if (role.getName().equals(roleName)) return true;
        return false;
    }

    public static boolean hasRole(User user, String roleName) {
        for (Role role : user.getRoles())
            if (role.getName().equals(roleName)) return true;
        return false;
    }
}
