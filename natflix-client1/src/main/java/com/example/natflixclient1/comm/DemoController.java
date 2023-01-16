package com.example.natflixclient1.comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/30
 * @since on
 */
@RestController
public class DemoController {

  @Autowired private GetClient client;

  @GetMapping("/hi")
  public String hi() {
    return "this client1";
  }

  @GetMapping("/his")
  public String his() {
    return client.his();
  }
}
