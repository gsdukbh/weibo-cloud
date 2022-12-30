package com.example.zookeeperdemo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/30
 * @since on
 */
@Configuration
@EnableDiscoveryClient
@EnableFeignClients
public class DemoClient {

  @Autowired Tehl tehl;

  @FeignClient(name = "zookeeper")
  interface Tehl {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    String helloWord();
  }

  public String hello() {
    return tehl.helloWord();
  }
}
