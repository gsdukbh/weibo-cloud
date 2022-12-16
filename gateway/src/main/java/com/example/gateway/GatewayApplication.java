package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leejiawei
 */
@SpringBootApplication
@RestController
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  @GetMapping("/")
  public String h() {

    return "hello" ;
  }

  @Bean
  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder
        .routes()
        // Add a simple re-route from: /get to: http://httpbin.org:80
        // Add a simple "Hello:World" HTTP Header
        .route(
            p ->
                p.path("/get") // intercept calls to the /get path
                    .filters(f -> f.addRequestHeader("Hello", "World")) // add header
                    .uri("http://httpbin.org:80")) // forward to httpbin
        .build();
  }
}
