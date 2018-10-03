package com.narendra.springboot.jwtAuth.controller;

import com.narendra.springboot.jwtAuth.dao.ApplicationUser;
import com.narendra.springboot.jwtAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public Boolean createUser(@RequestBody ApplicationUser applicationUser) {
        return userService.createUser(applicationUser);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApplicationUser getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

}
