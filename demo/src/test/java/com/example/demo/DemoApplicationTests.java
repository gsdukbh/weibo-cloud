package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DemoApplicationTests {

  @Test
  void contextLoads() {
    Random random = new Random();


    List<Integer> a = new ArrayList<>();
    for (int i = 0; i < 100000; i++) {
      //
      a.add(random.nextInt());
    }
    long t= System.currentTimeMillis();
    Collections.sort(a);
    System.out.println( System.currentTimeMillis()-t);
  }
  @Test
  void  link(){
    Random random = new Random();

    List<Integer> a = new LinkedList<>();
    for (int i = 0; i < 100000; i++) {
      //
      a.add(random.nextInt());
    }
    long t= System.currentTimeMillis();
    Collections.sort(a);
    System.out.println( System.currentTimeMillis()-t);
  }
}
