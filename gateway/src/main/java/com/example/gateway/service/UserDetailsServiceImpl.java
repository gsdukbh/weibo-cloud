package com.example.gateway.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/19
 * @since on
 */
@Service
public class UserDetailsServiceImpl implements ReactiveUserDetailsService {


    /**
     * Find the {@link UserDetails} by username.
     *
     * @param username the username to look up
     * @return the {@link UserDetails}. Cannot be null
     */
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(() -> "ROLE_ADMIN");
        User user =
                new User(
                        username,
                        "$2a$10$ff5LAedpha10wc77nKjtc.J0FlkP4mAMMVvkVQV1H57Y7p0ekqo8e",
                        true,
                        true,
                        true,
                        true,
                        authorities);
        return Mono.just(user);
    }
}
