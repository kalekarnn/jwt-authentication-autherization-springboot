package com.narendra.springboot.jwtAuth.dao;

import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
    ApplicationUser findUserByUsername(String username);
}
