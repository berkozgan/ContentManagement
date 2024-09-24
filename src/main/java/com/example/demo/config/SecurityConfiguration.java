package com.example.demo.config;



public class SecurityConfiguration {

    /*
    private static final String[] AUTH_WHITE_LIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/v2/api-docs/**",
            "/swagger-resources/**",
            "/api/users/add",
            "/api/users/getAll"
    };

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
         http
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(AUTH_WHITE_LIST).permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users/add").permitAll()
                        .anyRequest().authenticated()
                );

         return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("user1")
                .password("12")
                .roles("USER")
                .build();
        UserDetails user2 = User
                .withUsername("user2")
                .password("21")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();
    }

     */

}
