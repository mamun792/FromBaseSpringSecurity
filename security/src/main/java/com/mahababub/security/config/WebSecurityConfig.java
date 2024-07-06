package com.mahababub.security.config;

import com.mahababub.security.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class WebSecurityConfig {

    private  final CustomUserDetailsService userDetailsService;

    public WebSecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    @SuppressWarnings("deprecation")
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .csrf(csrf -> csrf.disable())
               .headers(headerConfigurer -> headerConfigurer
                       .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)
               )
//               .authorizeHttpRequests(authorizeRequests ->
//                       authorizeRequests
//                               .requestMatchers(antMatcher("/**")).permitAll()
//                               .requestMatchers(antMatcher("/user/register/**")).permitAll()
//                               .requestMatchers(antMatcher("/user/**")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
//                            //   .requestMatchers(antMatcher("/admin/**")).hasAuthority("ROLE_ADMIN")
//                               .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//                               .anyRequest().fullyAuthenticated()
//               )

               .authorizeHttpRequests(authorizeRequests ->
                       authorizeRequests
                               .requestMatchers("/").permitAll()
                               .requestMatchers("/user/register/**").permitAll()
                               .requestMatchers("/admin/register/**").permitAll()
                               .requestMatchers("/user/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                               .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                               .anyRequest().fullyAuthenticated()
               )
               .formLogin( formLogin ->
                       formLogin
                               .loginPage("/")
                               .usernameParameter("username")
                               .passwordParameter("password")
                               .loginProcessingUrl("/login")
                               .defaultSuccessUrl("/dashboard")
                               .failureUrl("/?error=true")
               )
               .logout(logout ->
                       logout
                               .logoutUrl("/logout")

               )
        .userDetailsService(userDetailsService);
         return http.build();
    }
}
