package com.example.jungblee.global.config;

import com.example.jungblee.global.security.jwt.JwtTokenProvider;
//import com.example.jungblee.global.security.jwt.JwtValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfigure {
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    protected SecurityFilterChain configure(
            HttpSecurity httpSecurity
    ) throws Exception {
        return httpSecurity
                .cors().and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .anyRequest().permitAll()

                /*.and()
                .apply(new FilterConfig(jwtTokenProvider, jwtTokenResolver, objectMapper, userDetailsService))*/

                .and()
                .apply(new FilterConfig(jwtTokenProvider))

                .and()
                .build();
    }
}
