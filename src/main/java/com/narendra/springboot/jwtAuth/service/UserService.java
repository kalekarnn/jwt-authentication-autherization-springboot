package com.narendra.springboot.jwtAuth.service;

import com.narendra.springboot.jwtAuth.dao.ApplicationUser;
import com.narendra.springboot.jwtAuth.dao.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public boolean createUser(ApplicationUser applicationUser) {
        try {
            applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
            applicationUserRepository.save(applicationUser);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
