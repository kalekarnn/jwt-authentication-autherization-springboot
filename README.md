# jwt-oauth2-authentication-autherization-springboot

Method level security :

  @EnableGlobalMethodSecurity
  @PreAuthorize
  @PostAuthorize
  @Secured

  @PreAuthorize(“hasRole(‘ROLE_ADMIN’)”) has the same meaning as @Secured(“ROLE_ADMIN”). The Only difference is that @PreAuthorize supports SpEL wheare as @Secure doesn't. To enable this we need to add @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true
