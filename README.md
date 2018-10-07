# jwt-oauth2-authentication-autherization-springboot

Secure a Spring Boot REST API with oauth2

We can apply authorization at both resource level or method level.

Resource Server level :

    You can configure the HttpSecurity object as per requirement eg.
    http
        .antMatchers("/users/**").hasRole("ADMIN")

    NOTE : Spring adds "ROLE_" here before role match.
           Hence in DB your roles should start with ROLE_ if you are using this.

           the order of these antMatchers is important. it should be from more specific to less specific.
           eg.
                http
                    .antMatchers("/users/sign-up").permitAll()
                    .antMatchers("/users/**").hasRole("ADMIN")

Method level :

    @EnableGlobalMethodSecurity
    @PreAuthorize
    @PostAuthorize
    @Secured

    @PreAuthorize(“hasRole(‘ROLE_ADMIN’)”) has the same meaning as @Secured(“ROLE_ADMIN”).

    The Only difference is that @PreAuthorize supports SpEL wheare as @Secure doesn't.
    To enable this we need to add @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)

