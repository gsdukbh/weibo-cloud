package com.example.gateway.config;

import com.example.gateway.service.UserDetailsServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/20
 * @since on
 */
@Slf4j
@Component
public class DefaultSecurityContextRepository implements ServerSecurityContextRepository {

  @Resource private TokenAuthenticationManager tokenAuthenticationManager;
  /**
   * Saves the SecurityContext
   *
   * @param exchange the exchange to associate to the SecurityContext
   * @param context the SecurityContext to save
   * @return a completion notification (success or error)
   */
  @Override
  public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
    return Mono.empty();
  }

  /**
   * Loads the SecurityContext associated with the {@link ServerWebExchange}
   *
   * @param exchange the exchange to look up the {@link SecurityContext}
   * @return the {@link SecurityContext} to lookup or empty if not found. Never null
   */
  @Override
  public Mono<SecurityContext> load(ServerWebExchange exchange) {
    var http = exchange.getRequest();
    var token = http.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

    log.error("  this  load  "); 

    return  tokenAuthenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken("token", null))
        .map(SecurityContextImpl::new);
//    return Mono.empty();
  }
}
