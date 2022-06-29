package com.tek.genshinbuildapp.security;

import com.tek.genshinbuildapp.dao.AuthGroupRepository;
import com.tek.genshinbuildapp.model.AuthGroup;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrincipalUserService implements UserDetailsService {

    final UserService userService;
    final AuthGroupRepository authGroupRepository;

    @Autowired
    public PrincipalUserService(UserService userService, AuthGroupRepository authGroupRepository) {
        this.userService = userService;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.retrieveUser(username);
        }
        catch (EntityNotFoundException exc) {
            throw new UsernameNotFoundException("No user found with username " + username);
        }
        List<AuthGroup> authorities = authGroupRepository.findAllByUsername(username);

        return new PrincipalUser(user, authorities);
    }
}
