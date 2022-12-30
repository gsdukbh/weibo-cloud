package com.example.zookeeperdemo1;

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
public class TccController {

    @Autowired
    DemoClient demoClient;

    @GetMapping("/hia")
    public  String  hi(){
        return  demoClient.hello();
    }
}
