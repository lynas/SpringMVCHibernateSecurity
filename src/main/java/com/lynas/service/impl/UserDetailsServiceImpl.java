package com.lynas.service.impl;


import com.lynas.model.AppUser;
import com.lynas.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service(value = "UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.readOneUserByName(username);

        if (appUser != null) {
            Collection<GrantedAuthority> authorities = appUser.getRoles().stream()
                    .map(userRole -> new SimpleGrantedAuthority(userRole.getRoleName()))
                    .collect(Collectors.toCollection(ArrayList::new));

            return new org.springframework.security.core.userdetails.
                    User(username, appUser.getPassword(), true, true, true, true, authorities);
        }else {
            throw new UsernameNotFoundException("user name not found");
        }
    }
}
