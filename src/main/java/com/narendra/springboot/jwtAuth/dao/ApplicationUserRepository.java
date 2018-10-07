package com.narendra.springboot.jwtAuth.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long > {
    ApplicationUser findUserByUsername(String username);
}
