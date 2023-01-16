package com.example.natflixclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
public class NatflixClient1Application {

  public static void main(String[] args) {
    SpringApplication.run(NatflixClient1Application.class, args);
  }
}
