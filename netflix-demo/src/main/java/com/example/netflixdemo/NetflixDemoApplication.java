package com.example.netflixdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetflixDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(NetflixDemoApplication.class, args);
  }
}
