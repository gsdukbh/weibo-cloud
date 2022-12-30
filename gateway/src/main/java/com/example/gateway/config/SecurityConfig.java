package com.example.gateway.config;

import com.example.gateway.service.UserDetailsServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DelegatingReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/19
 * @since on
 */
@Configuration
@EnableWebFluxSecurity
@EnableWebFlux
public class SecurityConfig {

  @Resource private UserDetailsServiceImpl userDetailsService;


  @Resource private DefaultSecurityContextRepository defaultSecurityContextRepository;
  @Resource private TokenAuthenticationManager tokenAuthenticationManager;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityWebFilterChain config(ServerHttpSecurity http) {

    http.authorizeExchange().pathMatchers("/demo/hi").permitAll().anyExchange().denyAll();
    http.formLogin();
    http.authenticationManager(manager())
        .securityContextRepository(defaultSecurityContextRepository);
    return http.build();
  }

  @Bean
  public ReactiveAuthenticationManager manager() {
    List<ReactiveAuthenticationManager> managers = new ArrayList<>();
    managers.add(new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService));
    managers.add(tokenAuthenticationManager);
    return new DelegatingReactiveAuthenticationManager(managers);
  }
}
