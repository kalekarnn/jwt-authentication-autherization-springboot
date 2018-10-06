package com.narendra.springboot.jwtAuth.service;

import com.narendra.springboot.jwtAuth.dao.ApplicationUser;
import com.narendra.springboot.jwtAuth.dao.ApplicationUserRepository;
import com.narendra.springboot.jwtAuth.dao.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findUserByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

/*        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });*/


        List<SimpleGrantedAuthority> authorities  = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }
}
