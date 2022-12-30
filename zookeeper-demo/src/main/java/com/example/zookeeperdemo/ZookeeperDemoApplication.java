package com.example.zookeeperdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZookeeperDemoApplication.class, args);
  }
}
