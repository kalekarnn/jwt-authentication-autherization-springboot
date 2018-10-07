# jwt-oauth2-authentication-autherization-springboot

We can apply authorization at both resource level or method level.

Resource Server level :

    You can configure the HttpSecurity object as per requirement eg.
    http
        .antMatchers("/users/**").hasRole("ADMIN")

    NOTE : Spring adds "ROLE_" here before role match. Hence in DB your roles should start with ROLE_ if you are using this.

Method level :
