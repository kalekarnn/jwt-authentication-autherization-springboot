package com.narendra.springboot.jwtAuth.controller;

import com.narendra.springboot.jwtAuth.dao.ApplicationUser;
import com.narendra.springboot.jwtAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Boolean createUser(@RequestBody ApplicationUser applicationUser) {
        return userService.createUser(applicationUser);
    }

}
