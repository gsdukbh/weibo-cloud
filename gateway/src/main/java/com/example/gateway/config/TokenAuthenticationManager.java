package com.example.gateway.config;

import com.example.gateway.service.UserDetailsServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/20
 * @since on
 */
@Component
@Primary
@Slf4j
public class TokenAuthenticationManager implements ReactiveAuthenticationManager {
  @Resource private UserDetailsServiceImpl userDetailsService;
  /**
   * Attempts to authenticate the provided {@link Authentication}
   *
   * @param authentication the {@link Authentication} to test
   * @return if authentication is successful an {@link Authentication} is returned. If
   *     authentication cannot be determined, an empty Mono is returned. If authentication fails, a
   *     Mono error is returned.
   */
  @Override
  public Mono<Authentication> authenticate(Authentication authentication) {
    log.warn("   this  TokenAuthenticationManager {}", authentication);
    var username = authentication.getPrincipal().toString();
    return userDetailsService
        .findByUsername(username)
        .map(
            userDetails ->
                new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()));
  }
}
