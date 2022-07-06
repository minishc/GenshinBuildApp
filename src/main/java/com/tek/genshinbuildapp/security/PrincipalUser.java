package com.tek.genshinbuildapp.security;

import com.tek.genshinbuildapp.model.AuthGroup;
import com.tek.genshinbuildapp.model.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class PrincipalUser implements UserDetails {

    private final User user;
    private final List<AuthGroup> authorities;

    public PrincipalUser(User user, List<AuthGroup> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(authorities.isEmpty()) {return Collections.emptyList();}
        Set<GrantedAuthority> userAuthorities = new HashSet<>();
        authorities.forEach(authority -> userAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority())));
        return userAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
